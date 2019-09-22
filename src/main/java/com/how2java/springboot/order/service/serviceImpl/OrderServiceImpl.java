package com.how2java.springboot.order.service.serviceImpl;

import com.how2java.springboot.address.service.AddressService;
import com.how2java.springboot.coupon.service.CouponTypeUserService;
import com.how2java.springboot.goods.entity.Goods;
import com.how2java.springboot.goods.service.GoodsService;
import com.how2java.springboot.order.entity.Order;
import com.how2java.springboot.order.entity.OrderGoods;
import com.how2java.springboot.order.mapper.OrderMapper;
import com.how2java.springboot.order.service.OrderGoodsService;
import com.how2java.springboot.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper;
    @Autowired
    private OrderGoodsService orderGoodsService;
    @Autowired
    private CouponTypeUserService couponTypeUserService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddressService addressService;

    @Override
    @Transactional
    public int save(String goodsAndNum, String userId, String channelId, String addressId) {
        ArrayList<OrderGoods> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        long orderSn = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        String[] split = goodsAndNum.split(";");
        int save = 0;
        BigDecimal money = BigDecimal.ZERO;
        for (String s:split){
            String[] split1 = s.split(",");
            Goods byGoodsId = goodsService.getByGoodsId(split1[0]);
            //商品单价
            String money2 = byGoodsId.getMoney();
            //当前商品总价
            BigDecimal multiply = new BigDecimal(split1[1]).multiply(new BigDecimal(money2));
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setId(UUID.randomUUID().toString());
            orderGoods.setGoodsId(split1[0]);
            orderGoods.setNum(split1[1]);
            orderGoods.setCreateTime(now);
            orderGoods.setOrderSn(Long.toString(orderSn));
            List<Map<String, String>> byOpenIdAndGoodsId = couponTypeUserService.getByOpenIdAndGoodsId(userId, split1[0]+"1");
            if (byOpenIdAndGoodsId!=null&&byOpenIdAndGoodsId.size()>0){
                orderGoods.setCouponId(byOpenIdAndGoodsId.get(0).get("couponId"));
                String num = byOpenIdAndGoodsId.get(0).get("num");
                String surNum = byOpenIdAndGoodsId.get(0).get("seNum");
                String money1 = byOpenIdAndGoodsId.get(0).get("money");
                BigDecimal subtract = new BigDecimal(surNum).subtract(new BigDecimal(split1[1]));
                if (subtract.compareTo(BigDecimal.ZERO)>=0){
                    //当剩余次数大于当前订单数量时，订单总金额不增加
                    money = money.add(BigDecimal.ZERO);
                }else {
                    subtract = BigDecimal.ZERO;
                    //当前订单超出剩余次数的数量
                    BigDecimal subtract1 = new BigDecimal(split1[1]).subtract(new BigDecimal(surNum));
                    BigDecimal multiply1 = subtract1.multiply(new BigDecimal(money2));
                    money = money.add(multiply1);
                }
                int id = couponTypeUserService.updateNum(subtract.toString(), num, money1, byOpenIdAndGoodsId.get(0).get("couponTypeId"));
            }else {
                //没有优惠的时候，商品总价累加
                money = money.add(multiply);
            }
            save = orderGoodsService.save(orderGoods);
        }
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setOrderSn(Long.toString(orderSn));
        order.setUserId(userId);
        order.setChannelId(channelId);
        order.setAddressId(addressId);
        order.setMoney(money.toString());
        order.setState("1");
        order.setCreateTime(now);
        return mapper.save(order);
    }

    @Override
    public List<Order> findByPeiSongId(String id) {
        List<Order> byPeiSongId = mapper.findByPeiSongId(id);
        return null;
    }
}
