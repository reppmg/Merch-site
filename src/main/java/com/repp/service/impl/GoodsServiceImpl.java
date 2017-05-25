package com.repp.service.impl;

import com.repp.dao.GoodsDao;
import com.repp.model.Good;
import com.repp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("goodsService")
public class GoodsServiceImpl implements GoodsService<Good> {


    @Autowired
    @Qualifier("goodsDao")
    private GoodsDao<Good, Long> goodsDao;

    @Override
    public Good findGoodById(final Long id) {
        return goodsDao.getGoodById(id);
    }

    @Override
    public List<Good> getList() {
        return goodsDao.getAll();
    }

    @Override
    public Long save(final Good good) {
        goodsDao.add(good);
        return good.getId();
    }

    @Override
    public void updateGood(final Good good) {

    }
}
