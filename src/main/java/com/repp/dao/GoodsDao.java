package com.repp.dao;

import com.repp.model.Good;

import java.util.List;

/**
 * @author Denis.Repp
 */
public interface GoodsDao {

    List<Good> getAll();
}
