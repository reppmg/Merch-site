package com.repp.dao;

import com.repp.model.Order;

import java.util.List;

/**
 * Created by 1 on 26.05.2017.
 */
public interface OrdersDao {

    List<Order> getOrders(Long userId);
}
