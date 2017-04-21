package com.repp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 1 on 21.04.2017.
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

