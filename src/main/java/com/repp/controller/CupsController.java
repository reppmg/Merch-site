package com.repp.controller;

import com.repp.model.Cup;
import com.repp.service.GoodsService;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 15.04.2017.
 */

@RestController
@RequestMapping("/cup")
public class CupsController {

    @Inject
    UsersService usersService;

    @Autowired
    @Qualifier("cupsService")
    private GoodsService<Cup> cupsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cup> getCups() {
        return cupsService.getList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cup getOneCup(@PathVariable final String id) {
        return cupsService.findGoodById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCup(OAuth2Authentication authentication, @RequestBody final Cup cup) {
        if (usersService.checkAuthorities(Long.valueOf(((Map) ((List) ((Map) authentication.getUserAuthentication().getDetails()).get("response")).get(0)).get("uid").toString())))
            cupsService.save(cup);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateCup(OAuth2Authentication authentication, @RequestBody final Cup cup) {
        if (usersService.checkAuthorities(Long.valueOf(((Map) ((List) ((Map) authentication.getUserAuthentication().getDetails()).get("response")).get(0)).get("uid").toString())))
            cupsService.updateGood(cup);
    }


}
