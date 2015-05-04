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

/**
 *
 *
 * @author wbatista
 */
public class CervejariaModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(BeerService.class).to(BeerServiceStub.class);
        bindListener(beerServiceMatcher(), typeListener());
    }

    /**
     * Matcher for BeerServiceStub PostConstruct
     * 
     * @return Matcher
     */
    private Matcher<? super TypeLiteral<?>> beerServiceMatcher() {

        return Matchers.only(new TypeLiteral<BeerServiceStub>() {
        });
    }

    /**
     * TypeListener for BeerServiceStub PostConstruct
     * 
     * @return TypeListener
     */
    private TypeListener typeListener() {

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
}
