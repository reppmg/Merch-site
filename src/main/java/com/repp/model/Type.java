package com.repp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * type model
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

