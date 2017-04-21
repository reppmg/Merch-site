package com.repp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Модель товара
 */
//@Setter
//@Getter
@Entity
@Data
@Table(name = "goods", schema = "PUBLIC")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long price;

    private Integer type_id;
    private String name;
    private String description;

//    @ManyToMany(mappedBy = "goods")
////    @JoinTable(
////            name = "good_order",
////            schema = "PUBLIC",
////            joinColumns = @JoinColumn(name = "good_id", referencedColumnName = "id"),
////            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id")
////    )
//    private Set<Order> orders;


    public Good() {
    }


    public Good(Long price, int type_id, String name, String description) {
        this.price = price;
        this.type_id = type_id;
        this.name = name;
        this.description = description;
    }
}
