package com.how2java.springboot.order.service;

public interface OrderService {
    int save(String goodsAndNum,String openId,String channelId,String addressId);
}
