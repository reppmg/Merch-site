package com.repp.service;

import com.repp.dao.GoodsDao;
import com.repp.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("goodsService")
public class GoodsServiceImpl implements  GoodsService<Good, Long> {



    @Autowired
            @Qualifier("goodsDao")
    GoodsDao<Good, Long> goodsDao;

    @Override
    public Good getGoodById(Long id) {
        return goodsDao.getGoodById(id);
    }

    @Override
    public List<Good> getList() {
        return goodsDao.getAll();
    }

    @Override
    public boolean addGood(Good good) {
        return goodsDao.add(good);
    }
}
