package br.edu.fatec.cervejaria.service;

import br.edu.fatec.cervejaria.model.Beer;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 *
 *
 * @author wbatista
 */
public class BeerServiceStub implements BeerService {

    private final EntityManager em;

    @Inject
    public BeerServiceStub(final EntityManager em) {

        this.em = em;
    }

    @PostConstruct
    @Transactional
    public void init() {

        if (findAll().isEmpty()) {
            em.persist(new Beer("Bhrama 600ML", new BigDecimal("4.50")));
            em.persist(new Beer("Skol Lata 350ML", new BigDecimal("3.00")));
            em.persist(new Beer("Kaiser 600ML", new BigDecimal("5.20")));
            em.persist(new Beer("Paulaner 500ML", new BigDecimal("12.00")));
            em.persist(new Beer("Cristal Lata 350ML", new BigDecimal("2.50")));
        }
    }

    @Transactional
    public Long save(Beer beer) {

        return em.merge(beer).getId();
    }

    @Transactional
    public void delete(Long id) {

        em.remove(new Beer(id));
    }

    public Beer find(Long id) {

        return em.find(Beer.class, id);
    }

    public List<Beer> findAll() {

        return em.createQuery("from Beer order by name", Beer.class).getResultList();
    }
}
