package com.repp.dao;

import com.repp.model.Goods;

import java.util.List;

/**
 * DAO dealing with goods
 */
public interface GoodsDao {

    List<Goods> getAll();

    boolean add(Goods good);
}
