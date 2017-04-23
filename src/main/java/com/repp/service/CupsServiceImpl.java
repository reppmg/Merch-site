package com.repp.service;

import com.repp.dao.GoodsDao;
import com.repp.model.Cup;
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

    @Override
    public List<Cup> getList() {
        return goodsDao.getAll();
    }

    @Override
    public Cup getGoodById(Long id) {
        return null;
    } //fixme implement

    @Override
    public boolean addGood(Cup good) { //fixme make void
        goodsDao.add(good);
        return false;
    }
}
