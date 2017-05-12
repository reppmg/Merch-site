package com.repp.controller;

import com.repp.model.Cup;
import com.repp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 1 on 15.04.2017.
 */

@RestController
@RequestMapping("/cup")
public class CupsController {

    @Autowired
    @Qualifier("cupsService")
    GoodsService<Cup> cupsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cup> getCups(){
        return cupsService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCup(@RequestBody final Cup cup){
        cupsService.save(cup);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateCup(@RequestBody final Cup cup){
        cupsService.updateGood(cup);
    }

}
