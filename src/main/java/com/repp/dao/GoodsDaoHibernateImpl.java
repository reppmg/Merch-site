package com.repp.dao;

import com.repp.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Denis.Repp
 */
@Repository
@Transactional
public class GoodsDaoHibernateImpl implements GoodsDao{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Goods> getAll() {
        List<Goods> resultList = entityManager.createQuery("from Goods").getResultList();
        return resultList;
    }

    @Override
    public boolean add(Goods good) {
        entityManager.persist(good);
        return false;
    }
}
