package com.how2java.springboot.order.service;

import com.how2java.springboot.order.entity.Order;

import java.util.List;

public interface OrderService {
    int save(String goodsAndNum,String openId,String channelId,String addressId);

    List<Order> findByPeiSongId(String id);
}
