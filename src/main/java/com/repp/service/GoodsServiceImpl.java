package com.repp.service;

import com.repp.dao.GoodsDao;
import com.repp.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Denis.Repp
 */
@Service
public class GoodsServiceImpl implements  GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Good> getList() {
        return goodsDao.getAll();
    }

    @Override
    public boolean addGood(Goods good) {
        return goodsDao.add(good);
    }
}
