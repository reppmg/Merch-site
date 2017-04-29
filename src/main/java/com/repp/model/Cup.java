package com.repp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Cup model
 */

@Entity
@Data
@Table(name = "cups", schema = "PUBLIC")

public class Cup {

    @Id
    private Long good_id;
    private Integer capacity;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Good good;

}
