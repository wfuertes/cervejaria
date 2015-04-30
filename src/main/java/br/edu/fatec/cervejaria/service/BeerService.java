/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.service;

import java.util.List;

import br.edu.fatec.cervejaria.model.Beer;

/**
 *
 *
 * @author wbatista
 */
public interface BeerService {

    Long save(Beer beer);

    void delete(Long id);

    Beer find(Long id);

    List<Beer> findAll();
}
