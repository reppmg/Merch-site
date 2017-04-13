package com.repp.controller;

import com.repp.model.Goods;
import com.repp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Denis.Repp
 */
@RestController
@RequestMapping("/good")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Goods>  getGoods() {
        return goodsService.getList();
    }


    @RequestMapping(method = RequestMethod.POST)
    public boolean addGood(@RequestBody final Goods good) {
        return goodsService.addGood(good);
    }

}
