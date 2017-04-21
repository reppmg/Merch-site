package com.repp.dao;

import com.repp.model.Cup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 1 on 15.04.2017.
 */

@Repository("cupsDao")
@SuppressWarnings("unchecked")
@Transactional
public class CupsDaoImpl implements GoodsDao<Cup, Long>{

    @Autowired
    EntityManager entityManager;

    @Override
    public boolean add(Cup good) {
        try {
            entityManager.persist(good);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Cup getGoodById(Long id) {
        return null;
    }


    @Override
    public List<Cup> getAll() {
        return entityManager.createQuery("from Cup ").getResultList();
    }


}
