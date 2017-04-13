package com.repp.service;

import com.repp.model.Goods;

import java.util.List;

/**
 * Service, dealing with goods
 */
public interface GoodsService {

    List<Goods> getList();

    boolean addGood(Goods good);
}
