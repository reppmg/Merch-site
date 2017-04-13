package com.repp.controller;

import com.repp.model.Good;
import com.repp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Denis.Repp
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Good>  getGoods() {
        return goodsService.getList();
    }

}
