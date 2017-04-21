package com.repp.dao;

import com.repp.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * DAO implementation using hibernate
 */
@Repository("goodsDao")
@SuppressWarnings("unchecked")
@Transactional
public class GoodsDaoHibernateImpl implements GoodsDao<Good, Long>{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Good getGoodById(Long id) {
        List result = entityManager.createQuery("from Good WHERE id LIKE :id").setParameter("id", id)
                .getResultList();
        if (result == null || result.isEmpty()){
            return null;
        }
        return (Good) result.get(0);
    }


    @Override
    public List<Good> getAll() {
        List<Good> resultList = entityManager.createQuery("from Good").getResultList();
        return resultList;
    }

    @Override
    public boolean add(Good good) {
        entityManager.persist(good);
        return true;
    }
}
