/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.config;

import br.edu.fatec.cervejaria.service.BeerService;
import br.edu.fatec.cervejaria.service.BeerServiceStub;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author wbatista
 */
public class CervejariaModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(CervejariaModule.class);

    @Override
    protected void configure() {

        bind(BeerService.class).to(BeerServiceStub.class);
        bindListener(Matchers.any(), postConstructorListener());
    }

    /**
     * Matcher for BeerServiceStub PostConstruct
     * 
     * @return Matcher
     */
    @SuppressWarnings("unused")
    private Matcher<? super TypeLiteral<?>> beerServiceMatcher() {

        return Matchers.only(new TypeLiteral<BeerServiceStub>() {
        });
    }

    /**
     * TypeListener for BeerServiceStub PostConstruct
     * 
     * @return TypeListener
     */
    @SuppressWarnings("unused")
    private TypeListener beerServiceListener() {

        return new TypeListener() {

            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {

                encounter.register(new InjectionListener<I>() {

                    @Override
                    public void afterInjection(Object obj) {

                        ((BeerServiceStub) obj).init();
                    }
                });
            }
        };
    }

    /**
     * TypeListener for methods annotated with @PostConstruct
     * 
     * @return TypeListener
     */
    private TypeListener postConstructorListener() {

        return new TypeListener() {

            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {

                encounter.register(new InjectionListener<I>() {

                    @Override
                    public void afterInjection(Object obj) {

                        Class<?> superclass = obj.getClass().getSuperclass();
                        for (Method method : superclass.getMethods()) {
                            try {
                                PostConstruct[] annotations = method.getAnnotationsByType(PostConstruct.class);
                                if (annotations.length > 0) {
                                    method.invoke(obj);
                                }
                            } catch (Exception e) {
                                LOG.error("Erro ao chamar o PostConstructor para: " + method.getName());
                            }
                        }
                    }
                });
            }
        };
    }
}
