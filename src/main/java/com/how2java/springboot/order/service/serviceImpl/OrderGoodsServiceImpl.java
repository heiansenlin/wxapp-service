package com.how2java.springboot.order.service.serviceImpl;

import com.how2java.springboot.goods.entity.Goods;
import com.how2java.springboot.order.entity.OrderGoods;
import com.how2java.springboot.order.mapper.OrderGoodsMapper;
import com.how2java.springboot.order.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
    @Autowired
    private OrderGoodsMapper mapper;
    @Override
    public int save(OrderGoods orderGoods) {
        return mapper.save(orderGoods);
    }

    @Override
    public List<Goods> findGoodsByOrderSn(String sn) {
        return mapper.findGoodsByOrderSn(sn);
    }
}
