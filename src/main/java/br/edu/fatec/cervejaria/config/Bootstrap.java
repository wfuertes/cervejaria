package br.edu.fatec.cervejaria.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
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

            private static final String CERVEJARIA_PERSISTENCE_UNIT = "CervejariaPersistenceUnit";

            @Override
            protected void configureServlets() {

                install(new CervejariaModule());
                install(new JpaPersistModule(CERVEJARIA_PERSISTENCE_UNIT));

                final Map<String, String> params = new HashMap<>();
                params.put(PackagesResourceConfig.PROPERTY_PACKAGES, "br.edu.fatec");

                filter("/*").through(PersistFilter.class);
                serve("/api/*").with(GuiceContainer.class, params);
            }

            @Provides
            @Singleton
            public ObjectMapper getObjectMapper() {

                final ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JaxbAnnotationModule());
                mapper.setPropertyNamingStrategy(PropertyNamingStrategy.PASCAL_CASE_TO_CAMEL_CASE);
                mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

                return mapper;
            }

            @Provides
            @Singleton
            public JacksonJaxbJsonProvider getJacksonJaxbJsonProvider(ObjectMapper mapper) {

                return new JacksonJaxbJsonProvider(mapper, JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS);
            }
        });
    }
}
