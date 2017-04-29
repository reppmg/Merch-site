package com.repp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Shit model
 */
@Entity
@Data
@Table(name = "shirts", schema = "PUBLIC")
public class Shirt {

    @Id
    private Long good_id;

    private String size;
    private String color;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Good good;

}
