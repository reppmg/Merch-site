package com.repp.service.impl;

import com.repp.dao.CupsRepository;
import com.repp.dao.GoodsRepository;
import com.repp.model.Cup;
import com.repp.service.GoodsService;
import com.repp.model.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 1 on 15.04.2017.
 */

@Service(value = "cupsService")
public class CupsServiceImpl<T, PK> implements GoodsService<Cup> {

    @Autowired
    CupsRepository cupsRepository;

    @Autowired
    GoodsRepository goodsRepository;

    @Override
    public void updateGood(final Cup cup) {
        cupsRepository.save(cup);
    }

    @Override
    public List<Cup> getList() {
        return cupsRepository.findAll();
    }

    @Override
    public Cup findGoodById(final Long id) {
        return cupsRepository.findOne(id);
    }


    @Override
    public Long save(final Cup cup) {
        cup.getGood().setType(Types.cupType);
        goodsRepository.save(cup.getGood());
        cup.setGood_id(cup.getGood().getId());
        final Cup savedOne = cupsRepository.save(cup);


        return savedOne.getGood_id();
    }
}
