package com.repp.service.impl;

import com.repp.dao.OrdersRepository;
import com.repp.model.Address;
import com.repp.model.Good;
import com.repp.model.Order;
import com.repp.model.User;
import com.repp.service.AddressService;
import com.repp.service.GoodsService;
import com.repp.service.OrdersService;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 1 on 20.04.2017.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AddressService addressService;

    @Qualifier("goodsService")
    @Autowired
    private GoodsService<Good> goodService;


    @Override
    public List<Order> getList(final Long userId) {
        final List<Order> allOrders = (List<Order>) ordersRepository.findAll();

        return null;
    }

    @Override
    public List<Order> getList() {
        return (List<Order>) ordersRepository.findAll();
    }

    @Override
    public Long save(final Order order, final Address address, final Long userId, final Long goodId) {
        final User user = usersService.findById(userId);
        order.setUser(user);

        final Long addressId;
        if (address == null) {
            addressId = user.getAddress().getId();
        } else {
            addressId = addressService.addAddress(address);
        }
        order.setAddress_id(addressId);

        if (order.getPhone() == null){
            order.setPhone(user.getPhone());
        }
        if (order.getEmail() == null){
            order.setEmail(user.getEmail());
        }

        final Set<Good> goods = new HashSet<>();
        final Good good = new Good();
        good.setId(goodId);
        goods.add(good);
        order.setGoods(goods);

        final Order saved = ordersRepository.save(order);
        return saved.getId();
    }

}
