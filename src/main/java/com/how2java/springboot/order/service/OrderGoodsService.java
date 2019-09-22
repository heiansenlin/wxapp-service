package com.how2java.springboot.order.service;

import com.how2java.springboot.goods.entity.Goods;
import com.how2java.springboot.order.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsService {
    int save(OrderGoods orderGoods);

    /**
     * 根据订单号查询订单商品
     * @param sn 订单编号
     * @return list
     */
    List<Goods> findGoodsByOrderSn(String sn);
}
