package com.repp.service;

import java.util.List;

/**
 * Service, dealing with goods
 */
public interface GoodsService<T, PK> {

    List<T> getList();

    T getGoodById(PK id);

    boolean addGood(T good);
}
