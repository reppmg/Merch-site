package com.repp.dao;

import com.repp.model.Good;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 1 on 25.04.2017.
 */
public interface GoodsRepository extends CrudRepository<Good, Long> {
    Good save(Good good);
}
