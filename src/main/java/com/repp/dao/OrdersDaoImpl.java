package com.repp.dao;

import com.repp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 1 on 26.05.2017.
 */
@Repository("ordersDao")
@SuppressWarnings("unchecked")
@Transactional
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Order> getOrders(final Long userId) {
        final List result = entityManager.createQuery("from Order WHERE user_id LIKE :id").setParameter("id", userId)
                .getResultList();
        if (result == null || result.isEmpty()){
            return null;
        }
        return result;
    }
}
