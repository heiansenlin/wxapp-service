package com.how2java.springboot.order.controller;

import com.how2java.springboot.order.entity.Order;
import com.how2java.springboot.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @RequestMapping("save")
    @ResponseBody
    public int saveOrder(String goodsAndNum,String userId,String channelId,String addressId){
        return service.save(goodsAndNum, userId, channelId, addressId);
    }

    /**
     * 配送人员查看需要配送的订单列表
     * @param id 配送人员ID
     * @return list
     */
    @RequestMapping("findByPeiSongId")
    @ResponseBody
    public List<Order> findByPeiSongId(String id){
        return null;
    }
}
