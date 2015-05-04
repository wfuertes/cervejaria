/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package br.edu.fatec.cervejaria.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 *
 * @author wbatista
 */
@Entity
@Table(name = "beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    public Beer() {

    }

    /**
     * @param id
     */
    public Beer(Long id) {

        this.id = id;
    }

    /**
     * @param name
     * @param price
     */
    public Beer(String name, BigDecimal price) {

        this.name = name;
        this.price = price;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Beer other = (Beer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
