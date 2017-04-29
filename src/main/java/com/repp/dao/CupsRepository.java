package com.repp.dao;

import com.repp.model.Cup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 1 on 19.04.2017.
 */
@Repository
@Transactional
public interface CupsRepository extends CrudRepository<Cup, Long> {

    List<Cup> findAll();

    List<Cup> findCupsByGood_Name(String name);

    Cup save(Cup cup);
}

