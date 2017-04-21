package com.repp.dao;

import com.repp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by 1 on 19.04.2017.
 */
@Repository
@Transactional
public interface UsersRepository extends CrudRepository<User, Long>{

}
