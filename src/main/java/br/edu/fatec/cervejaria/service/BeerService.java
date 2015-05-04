package br.edu.fatec.cervejaria.service;

import br.edu.fatec.cervejaria.model.Beer;

import java.util.List;

/**
 *
 *
 * @author wbatista
 */
public interface BeerService    {

    Long save(Beer beer);

    void delete(Long id);

    Beer find(Long id);

    List<Beer> findAll();
}
