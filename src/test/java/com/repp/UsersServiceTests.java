package com.repp;

import com.repp.model.Address;
import com.repp.model.User;
import com.repp.service.AddressService;
import com.repp.service.UsersService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTests {


    @Autowired
    UsersService usersService;

    @Autowired
    AddressService addressService;

    User user;

    @Before
    public void init(){
        user = new User();
        user.setId(51809846L);
        user.setName("Name");
        user.setSurname("Name");
        user.setEmail("pukachu@poke.mon");
        user.setPhone("88005553535");
        Address address = new Address(null, "615000", "Avenue Anatole", "5-6");
        user.setAddress(address);
        user.setRights(0);
    }

    @Test
    public void testGetList() {
        addressService.addAddress(user.getAddress());
        usersService.save(user);
        User fromDB = usersService.findById(user.getId());
        assertThat(fromDB.getPhone()).isEqualTo(user.getPhone());
    }
}
