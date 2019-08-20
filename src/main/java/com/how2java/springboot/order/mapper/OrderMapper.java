package com.how2java.springboot.order.mapper;

import com.how2java.springboot.order.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    @Insert("insert into order_table (id,orderSn,openId,channelId,addressId,couponId,money,state,createTime) " +
            "values (,#{o.id},#{o.orderSn},#{o.openId},#{o.channelId},#{o.addressId},#{o.couponId},#{o.money},#{o.state},#{o.createTime})")
    int save(@Param("o") Order order);
}
