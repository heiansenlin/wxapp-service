package com.how2java.springboot.order.controller;

import com.how2java.springboot.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @RequestMapping("save")
    @ResponseBody
    public boolean saveOrder(String goodsAndNum,String openId,String channelId,String addressId){
        return true;
    }
}
