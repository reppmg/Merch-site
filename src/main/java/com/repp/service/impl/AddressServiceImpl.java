package com.repp.service.impl;

import com.repp.dao.AddressRepository;
import com.repp.model.Address;
import com.repp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 1 on 21.05.2017.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Long addAddress(Address address) {
        Long id = addressRepository.save(address).getId();
        return id;
    }
}
