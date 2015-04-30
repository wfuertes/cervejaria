/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.rest;

import br.edu.fatec.cervejaria.service.BeerService;

import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 *
 * @author wbatista
 */
@Path("beer")
public class BeerResource {

    private final BeerService beerService;

    @Inject
    public BeerResource(final BeerService beerService) {

        this.beerService = beerService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAll() {

        return Response.ok(beerService.findAll()).build();
    }
}