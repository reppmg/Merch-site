package com.repp.controller;

import com.repp.dto.OrderDTO;
import com.repp.model.Order;
import com.repp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 20.04.2017.
 */

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return ordersService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addOrder(@RequestBody final OrderDTO orderDTO) {
        final Long goodId = orderDTO.getGood_id();
        final Order order = new Order();

        order.setCreation_date(new Date());
        order.setEmail(orderDTO.getEmail());
        order.setPhone(orderDTO.getPhone());


        ordersService.save(order, orderDTO.getAddress(), orderDTO.getUser_id(), orderDTO.getGood_id());

    }
}

