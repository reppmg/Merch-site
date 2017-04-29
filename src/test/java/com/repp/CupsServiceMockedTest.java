package com.repp;


import com.repp.dao.CupsRepository;
import com.repp.dao.GoodsRepository;
import com.repp.service.impl.CupsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CupsServiceMockedTest {

    @Mock
    GoodsRepository goodsRepository;
    @Mock
    private CupsRepository cupsRepository;
    @InjectMocks
    private CupsServiceImpl cupsService;

//
//    @Test
//    public void testAddCup(){
//        when(goodsRepository.save().then()
//    }

    @Test
    public void testGetList() {
        when(cupsRepository.findAll()).thenReturn(new ArrayList<>());
        cupsService.getList();
        verify(cupsRepository).findAll();
    }
}
