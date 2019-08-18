package com.how2java.springboot.channel.controller;

import com.how2java.springboot.channel.entity.Channel;
import com.how2java.springboot.channel.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private ChannelService service;

        @RequestMapping("/findAllByType")
    @ResponseBody
    public List<Channel> findAllByType(String type){
        return service.findAllByType(type);
    }
}
