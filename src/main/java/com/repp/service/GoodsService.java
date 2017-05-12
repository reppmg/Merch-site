package com.repp.service;

import java.util.List;

/**
 * Service, dealing with goods
 */
public interface GoodsService<T> {

    List<T> getList();

    T findGoodById(Long id);

    Long save(T good);

    void updateGood(T good);
}
