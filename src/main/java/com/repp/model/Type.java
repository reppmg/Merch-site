package com.repp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * type model
 */

@Entity
@Data
@Table(name = "types", schema = "PUBLIC")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

//    @OneToMany
//    @MapsId
//    private Set<Good> goods;
}

