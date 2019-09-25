package com.how2java.springboot.order.service;

import com.how2java.springboot.order.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    int save(String goodsAndNum,String openId,String channelId,String addressId);

    /**
     * 根据配送人员ID查询改员工的订单
     * @param id
     * @return
     */
    List<Order> findByPeiSongId(String id);

    /**
     * 根据门店ID查询门店员工以及每个员工的订单数量
     * @param channelId 门店ID
     * @return  list
     */
    List<Map<String,String>> findByChannelId(String channelId);
}
