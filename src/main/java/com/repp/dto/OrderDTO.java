package com.repp.dto;

import com.repp.model.Address;
import lombok.Data;

/**
 * Created by 1 on 21.05.2017.
 */
@Data
public class OrderDTO {
    Address address;
    Long good_id;
    String email;
}
