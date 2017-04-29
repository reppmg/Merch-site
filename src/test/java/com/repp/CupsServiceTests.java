package com.repp;

import com.repp.model.Cup;
import com.repp.model.Good;
import com.repp.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CupsServiceTests {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private
    GoodsService<Cup> cupsService;

    @Test
    public void testGetAllCups(){
        assertThat(cupsService.getList().size()).isGreaterThanOrEqualTo(3);
        assertThat(cupsService.getList().size()).isLessThan(4);
    }

    @Test
    @Transactional
    public void testAddCup(){
        Cup cup = new Cup();
        Good good = new Good();
        good.setDescription("description");
        good.setName("cup for java");
        good.setPrice(1488L);
        good.setType_id(2);
        cup.setGood(good);
        cup.setCapacity(400);

        long id = cupsService.addGood(cup);

        Cup foundCup = cupsService.findGoodById(id);

        assertThat(cup).isNotNull();
        cup.setGood_id(id);
        cup.getGood().setId(id);
        assertThat(cup).isEqualTo(foundCup);
    }

}
