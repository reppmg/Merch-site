package com.repp.controller;

import com.repp.model.Cup;
import com.repp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 1 on 15.04.2017.
 */

@RestController
@RequestMapping("/cup")
public class CupsController {

    @Autowired
    @Qualifier("cupsService")
    GoodsService<Cup, Long> cupsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cup> getCups(){
        return cupsService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean addCup(@RequestBody final Cup cup){
        return cupsService.addGood(cup);
    }



}
