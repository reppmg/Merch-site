package com.repp;

import com.repp.dao.CupsRepository;
import com.repp.dao.GoodsDao;
import com.repp.dao.UsersRepository;
import com.repp.model.Cup;
import com.repp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 1 on 19.04.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTests implements ApplicationContextAware{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CupsRepository cupsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    @Qualifier("cupsDao")
    GoodsDao<Cup, Long> cupsDao;

    @Autowired
    ApplicationContext ds;

    @Test
    public void testCupsRepoFindAll() {
        List<Cup> cups = (List<Cup>) this.cupsRepository.findAll();
        assertThat(cups).isNotNull();
        assertThat(cups.size()).isGreaterThan(0);
    }

    @Test
    public void testCupsRepoFindByName(){
        List<Cup> cups = cupsRepository.findCupsByGood_Name("coffee cup");
//        cups.forEach(el -> log.info(el.toString()));
        assertThat(cups).isNotNull();
        assertThat(cups.size()).isGreaterThan(0);
    }

    @Test
    public void testUsersRepoFindAll(){
        List<User> users = (List<User>) this.usersRepository.findAll();
        assertThat(users).isNotNull();
        assertThat(users.size()).isGreaterThan(0);
        users.forEach(el -> log.info(el.toString()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
