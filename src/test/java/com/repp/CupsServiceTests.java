package com.repp;

import com.repp.model.Cup;
import com.repp.model.Good;
import com.repp.service.GoodsService;
import org.junit.BeforeClass;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private
    GoodsService<Cup> cupsService;

    private static Cup cup;

    @BeforeClass
    public static void beforeClass() {
        cup = new Cup();
        Good good = new Good();
        good.setDescription("description");
        good.setName("cup for java");
        good.setPrice(1488L);
        good.setType_id(2);
        cup.setGood(good);
        cup.setCapacity(400);
    }

    @Test
    public void testGetAllCups() {
        assertThat(cupsService.getList().size()).isGreaterThanOrEqualTo(3);
        assertThat(cupsService.getList().size()).isLessThan(4);
    }

    @Test
    @Transactional
    public void testAddCup() {
        cup.getGood().setId(null);
        cup.setGood_id(null);

        long id = cupsService.save(cup);
        assertThat(id).isNotZero();

        Cup foundCup = cupsService.findGoodById(id);
        assertThat(cup).isNotNull();
        cup.setGood_id(id);
        cup.getGood().setId(id);
        assertThat(cup).isEqualTo(foundCup);

    }

    @Test
    @Transactional
    public void testUpdateCup(){

        cupsService.save(cup);

        cup.setCapacity(146);

        cupsService.save(cup);

        Cup foundCup = cupsService.findGoodById(cup.getGood_id());
        assertThat(foundCup.getCapacity()).isEqualTo(cup.getCapacity());
    }



}
