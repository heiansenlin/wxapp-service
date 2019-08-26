package com.how2java.springboot.address.controller;

import com.how2java.springboot.address.entity.Address;
import com.how2java.springboot.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService service;

    @RequestMapping("/findAllByOpenId")
    @ResponseBody
    public List<Address> findAllByOpenId(String userid){
        return service.findAllByOpenId(userid);
    }

    @RequestMapping("/save")
    @ResponseBody
    public int save(@RequestParam("userid") String userid,@RequestParam("address") String address){
        Address addre = new Address();
        addre.setId(UUID.randomUUID().toString());
        addre.setUserid(userid);
        addre.setAddress(address);
        return service.save(addre);
    }
}
