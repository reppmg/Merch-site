package com.repp.controller;

import com.repp.dto.OrderDTO;
import com.repp.model.Good;
import com.repp.model.Order;
import com.repp.service.AddressService;
import com.repp.service.GoodsService;
import com.repp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 1 on 20.04.2017.
 */

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    AddressService addressService;

    @Autowired
    GoodsService<Good> goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return ordersService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addOrder(OrderDTO orderDTO){
        Long addressId = addressService.addAddress(orderDTO.getAddress());
        Long goodId = orderDTO.getGood_id();
        Order order = new Order();
        order.setAddress_id(addressId);
        Good good = goodsService.findGoodById(goodId);
        Set<Good> set = new HashSet<>();
        set.add(good);
        order.setGoods(set);
        order.setCreation_date(new Date());
        order.setEmail(orderDTO.getEmail());

        ordersService.save(order);

    }
}

