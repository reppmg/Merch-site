package com.repp.service;

import com.repp.dao.OrdersRepository;
import com.repp.model.Good;
import com.repp.model.Order;
import com.repp.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 1 on 25.05.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private AddressService addressService;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private UsersService usersService;

    @Autowired
    GoodsService<Good> goodsService;

    @Before
    public void init(){
        final Order order = new Order();
        order.setCreation_date(new Date());
        order.setEmail("pi@ka.chu");
        order.setPhone("88005553535");

        final Long addressId = 1L;
        order.setAddress_id(addressId);

        final User user = usersService.findById(51809846L);
        order.setUser(user);

        final Set<Good> goods = new HashSet<>();
        final Good good = goodsService.findGoodById(1L);
        goods.add(good);
        order.setGoods(goods);

        final Order saved = ordersRepository.save(order);
        final Order found = ordersRepository.findOne(order.getId());
        assertThat(saved.getUser().getEmail()).isNotNull();
        saved.getGoods().forEach(x ->{assertThat(x.getName()).isNotNull();});
    }


    @Test
    public void getList() throws Exception {
        final List<Order> list = ordersService.getList();
        assertThat(list.size()).isGreaterThanOrEqualTo(2);
    }

    @Test
    public void save() throws Exception {

    }

}