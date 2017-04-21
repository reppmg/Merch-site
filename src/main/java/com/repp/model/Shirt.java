package com.repp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 1 on 21.04.2017.
 */
@Entity
@Data
@Table(name = "shirts", schema = "PUBLIC")
public class Shirt {

    @Id
    private Long good_id;

    private String size;
    private String color;

    @OneToOne
    @MapsId
    private Good good;

}
