/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.model;

import java.math.BigDecimal;

/**
 *
 *
 * @author wbatista
 */
public class Beer {

    private Long id;
    private String name;
    private BigDecimal price;

    public Beer() {

    }

    /**
     * @param id
     * @param name
     * @param price
     */
    public Beer(Long id, String name, BigDecimal price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * @return the id
     */
    public Long getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {

        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {

        this.price = price;
    }
}
