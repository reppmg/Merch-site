package com.repp.dao;

import com.repp.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by 1 on 20.04.2017.
 */
@Repository
@Transactional
public interface OrdersRepository extends CrudRepository<Order, Long> {

}
