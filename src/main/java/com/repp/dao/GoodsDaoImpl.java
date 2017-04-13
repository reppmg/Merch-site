package com.repp.dao;

import com.repp.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Denis.Repp
 */
@Repository
public class GoodsDaoImpl implements GoodsDao{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Good> getAll() {
        return jdbcTemplate.query("SELECT ID, PRICE FROM GOODS", (resultSet, i) -> new Good(resultSet.getLong(1), resultSet.getLong(2)));
    }
}
