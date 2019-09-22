package com.how2java.springboot.address.service.serviceImpl;

import com.how2java.springboot.address.entity.Address;
import com.how2java.springboot.address.mapper.AddressMapper;
import com.how2java.springboot.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper mapper;

    @Override
    public List<Address> findAllByOpenId(String userid) {
        return mapper.findAllByOpenId(userid);
    }

    @Override
    public int save(Address address) {
        return mapper.save(address);
    }

    @Override
    public Address getById(String id) {
        return mapper.getById(id);
    }


}

