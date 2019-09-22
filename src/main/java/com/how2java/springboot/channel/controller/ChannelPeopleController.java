package com.how2java.springboot.channel.controller;

import com.how2java.springboot.channel.entity.ChannelPeople;
import com.how2java.springboot.channel.service.ChannelPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ChannelPeople")
public class ChannelPeopleController {
    @Autowired
    private ChannelPeopleService service;

    @RequestMapping("/getByPeopleId")
    @ResponseBody
    public ChannelPeople getByPeopleId(String id){
        return service.getByPeopleId(id);
    }
}
