package com.repp.controller;

import com.repp.dao.ShirtsRepository;
import com.repp.model.Shirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 1 on 21.04.2017.
 */

@RestController
@RequestMapping("/shirt")
public class ShirtsController {

    @Autowired
    ShirtsRepository shirtsRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Shirt> getAllShirts(){
        return (List<Shirt>) shirtsRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Shirt getOneShirt(@PathVariable String id){
        return shirtsRepository.findOne(Long.valueOf(id));
    }

}
