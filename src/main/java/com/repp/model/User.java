package com.repp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * user model
 */

@Entity
@Getter
@Setter
@Table(name = "users", schema = "PUBLIC")
public class User {

    @Id
    private Long id;

    private String name;
    private String surname;

    private String email;
    private String phone;
    private Integer rights;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
