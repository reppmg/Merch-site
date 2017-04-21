package com.repp.service;

import com.repp.dao.OrdersRepository;
import com.repp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 1 on 20.04.2017.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Order> getList() {
        return  (List<Order>) ordersRepository.findAll();
    }
}
