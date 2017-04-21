package com.repp.dao;

import java.util.List;

/**
 * DAO dealing with goods
 */

public interface GoodsDao<T, PK> {

    List<T> getAll();

    boolean add(T good);

    T getGoodById(PK id);

}
