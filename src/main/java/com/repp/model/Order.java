package com.repp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by 1 on 14.04.2017.
 */

@Entity
@Data
@Table(name = "orders", schema = "PUBLIC")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long address_id;
    private String email;
    private Date creation_date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @ManyToMany
    @JoinTable(
            name = "good_order",
            schema = "PUBLIC",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "good_id", referencedColumnName = "id")
    )
    private Set<Good> goods;


}
