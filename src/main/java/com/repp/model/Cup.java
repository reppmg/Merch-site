package com.repp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 1 on 14.04.2017.
 */

@Entity
@Data
@Table(name = "cups", schema = "PUBLIC")
public class Cup {

    @Id
    private Long good_id;
    private Integer capacity;

    @OneToOne
    @MapsId
    private Good good;

}
