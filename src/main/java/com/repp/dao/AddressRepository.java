package com.repp.dao;

import com.repp.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by 1 on 21.05.2017.
 */

@Repository
@Transactional
public interface AddressRepository extends CrudRepository<Address, Long>{
}
