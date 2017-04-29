package com.repp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @ElementCollection
    private List<String> images;

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


}
