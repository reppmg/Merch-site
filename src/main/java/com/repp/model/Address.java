package com.repp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by 1 on 18.04.2017.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses", schema = "PUBLIC")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zip;
    private String street;
    private String rest;

}
