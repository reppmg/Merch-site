package com.repp.controller;

import com.repp.model.Order;
import com.repp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 1 on 20.04.2017.
 */

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return ordersService.getList();
    }
}

