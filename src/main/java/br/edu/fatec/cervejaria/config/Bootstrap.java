/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author wbatista
 */
public class Bootstrap extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {

        return Guice.createInjector(new JerseyServletModule() {

            @Override
            protected void configureServlets() {

                install(new CervejariaModule());
                bind(JacksonJaxbJsonProvider.class).in(Scopes.SINGLETON);

                final Map<String, String> params = new HashMap<>();
                params.put(PackagesResourceConfig.PROPERTY_PACKAGES, "br.edu.fatec");

                serve("/api/*").with(GuiceContainer.class, params);
            }
        });
    }
}