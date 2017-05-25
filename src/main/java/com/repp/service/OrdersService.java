package com.repp.service;

import com.repp.model.Address;
import com.repp.model.Order;

import java.util.List;

/**
 * Created by 1 on 20.04.2017.
 */
public interface OrdersService {
    List<Order> getList();

    Long save(Order order, Address address, Long userId, Long goodId);
}
