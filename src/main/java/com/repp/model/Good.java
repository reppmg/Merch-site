package com.repp.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Denis.Repp
 */
@Setter
@Getter
public class Good {

    private Long id;
    private Long price;

    public Good(Long id, Long price) {
        this.id = id;
        this.price = price;
    }
}
