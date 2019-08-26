package com.how2java.springboot.address.service;

import com.how2java.springboot.address.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllByOpenId(String userid);

    int save (Address address);
}
