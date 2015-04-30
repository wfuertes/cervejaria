/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.service;

import br.edu.fatec.cervejaria.model.Beer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author wbatista
 */
public class BeerServiceStub implements BeerService {

    private static final Map<Long, Beer> beers = new HashMap<>();
    static {
        beers.put(1L, new Beer(1L, "Bhrama 600ML", new BigDecimal("3.49")));
        beers.put(2L, new Beer(2L, "Skol Lata 350LM", new BigDecimal("2.49")));
    }

    public Long save(Beer beer) {

        Long id = beer.getId() == null ? System.currentTimeMillis() + 1 : beer.getId();
        beer.setId(id);
        beers.put(id, beer);

        return id;
    }

    public void delete(Long id) {

        beers.remove(beers.get(id));
    }

    public Beer find(Long id) {

        return beers.get(id);
    }

    public List<Beer> findAll() {

        return new ArrayList<>(beers.values());
    }

}
