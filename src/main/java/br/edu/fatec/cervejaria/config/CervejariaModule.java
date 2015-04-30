/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.config;

import br.edu.fatec.cervejaria.service.BeerService;
import br.edu.fatec.cervejaria.service.BeerServiceStub;

import com.google.inject.AbstractModule;

/**
 *
 *
 * @author wbatista
 */
public class CervejariaModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(BeerService.class).to(BeerServiceStub.class);
    }

}
