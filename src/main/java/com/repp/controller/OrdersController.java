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

//    @Autowired
//    AddressService addressService;
//
//    @Autowired
//    GoodsService<Good> goodsService;
//
//    @Autowired
//    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return ordersService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addOrder(@RequestBody final OrderDTO orderDTO) {
        final Long goodId = orderDTO.getGood_id();
        final Order order = new Order();


//        final Long addressId = addressService.addAddress(orderDTO.getAddress());
//        order.setAddress_id(addressId);

//        final Good good = goodsService.findGoodById(goodId);
//        final Set<Good> set = new HashSet<>();
        //TODO rework
//        set.add(good);
//        order.setGoods(set);
        order.setCreation_date(new Date());
        order.setEmail(orderDTO.getEmail());
        order.setPhone(orderDTO.getPhone());

//        final User user = usersService.findById(orderDTO.getUser_id());
//        order.setUser(user);

        ordersService.save(order, orderDTO.getAddress(), orderDTO.getUser_id(), orderDTO.getGood_id());

    }
}

