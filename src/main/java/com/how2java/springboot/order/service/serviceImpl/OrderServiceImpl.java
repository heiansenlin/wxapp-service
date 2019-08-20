package com.how2java.springboot.order.service.serviceImpl;

import com.how2java.springboot.order.entity.Order;
import com.how2java.springboot.order.entity.OrderGoods;
import com.how2java.springboot.order.mapper.OrderMapper;
import com.how2java.springboot.order.service.OrderGoodsService;
import com.how2java.springboot.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper;
    @Autowired
    private OrderGoodsService orderGoodsService;

    @Override
    @Transactional
    public int save(String goodsAndNum, String openId, String channelId, String addressId) {
        ArrayList<OrderGoods> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        long orderSn = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        String[] split = goodsAndNum.split(";");
        for (String s:split){
            String[] split1 = s.split(",");
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setId(UUID.randomUUID().toString());
            orderGoods.setGoodsId(split1[0]);
            orderGoods.setNum(split1[1]);
            orderGoods.setCreateTime(now);
            orderGoods.setOrderSn(Long.toString(orderSn));
            int save = orderGoodsService.save(orderGoods);
        }
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setOrderSn(Long.toString(orderSn));
        order.setOpenId(openId);
        order.setChannelId(channelId);
        order.setAddressId(addressId);
        order.setState("1");
        order.setCreateTime(now);
        return mapper.save(order);
    }
}
