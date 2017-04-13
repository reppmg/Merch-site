package com.repp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Denis.Repp
 */
@Setter
@Getter
@Entity
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long price;
    private String name;

    public Good() {

    }


    public Good(Long id, Long price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
}
