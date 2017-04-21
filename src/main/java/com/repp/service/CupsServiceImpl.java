package com.repp.service;

import com.repp.dao.GoodsDao;
import com.repp.model.Cup;
import com.repp.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 1 on 15.04.2017.
 */

@Service(value = "cupsService")
public class CupsServiceImpl<T, PK> implements GoodsService<Cup, Long> {

    @Autowired
            @Qualifier("cupsDao")
    GoodsDao<Cup, Long> goodsDao;

    @Autowired
            @Qualifier("goodsService")
    GoodsService<Good, Long> goodsService;

    @Override
    public List<Cup> getList() {
        return goodsDao.getAll();
    }

    @Override
    public Cup getGoodById(Long id) {
        return null;
    }

    @Override
    public boolean addGood(Cup good) {
        goodsDao.add(good);
        return false;
    }
}
