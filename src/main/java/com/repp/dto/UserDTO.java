package com.repp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    Long user_id;

    String street;
    String rest;
    String zip;

    String email;
}
