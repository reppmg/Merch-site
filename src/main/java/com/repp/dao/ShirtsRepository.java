package com.repp.dao;

import com.repp.model.Shirt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 1 on 21.04.2017.
 */
@Repository
public interface ShirtsRepository extends CrudRepository<Shirt, Long>{

}
