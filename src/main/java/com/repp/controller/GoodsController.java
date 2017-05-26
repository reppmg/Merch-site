package com.repp.controller;

import com.repp.model.Good;
import com.repp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller, dealing with goods
 */
@RestController
@RequestMapping("/good")
public class GoodsController {

    @Autowired
    @Qualifier("goodsService")
    private GoodsService<Good> goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Good> getGoods() {
        return goodsService.getList();
    }

    @RequestMapping(value = "/{goodId}", method = RequestMethod.GET)
    public Good getGood(@PathVariable final String goodId) {
        final int id;
        try {
            id = Integer.parseInt(goodId);
        } catch (NumberFormatException e) {
            return null;
        }
        return goodsService.findGoodById((long) id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addGood(@RequestBody final Good good) {
        goodsService.save(good);
    }


}
