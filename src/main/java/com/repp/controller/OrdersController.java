package com.repp.controller;

import com.repp.dao.OrdersDao;
import com.repp.dto.OrderDTO;
import com.repp.model.Order;
import com.repp.service.OrdersService;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 1 on 20.04.2017.
 */

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Inject
    UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersDao ordersDao;


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

    @RequestMapping("/user/{pathUserId}")
    public List<Order> getOrdersForUser(final OAuth2Authentication authentication, @PathVariable final String pathUserId) {
        final Long uid;
        Long userId = Long.valueOf(((Map) ((List) ((Map) authentication.getUserAuthentication().getDetails()).get("response")).get(0)).get("uid").toString());
        try {
                uid = (long) Integer.parseInt(pathUserId);
                if (!Objects.equals(uid, userId)) {
                    return null;
                }
            } catch (NumberFormatException e) {
                return null;
            }
        return ordersDao.getOrders(uid);
    }
}

