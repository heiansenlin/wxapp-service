package com.how2java.springboot.order.mapper;

import com.how2java.springboot.order.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("insert into order_table (id,orderSn,userId,channelId,addressId,couponId,money,state,createTime) " +
            "values (#{o.id},#{o.orderSn},#{o.userId},#{o.channelId},#{o.addressId},#{o.couponId},#{o.money},#{o.state},#{o.createTime})")
    int save(@Param("o") Order order);


    @Select("select * from order_table where peiSongId = #{id}")
    @Results({
            @Result(property = "address",column = "addressId",one = @One(select = "com.how2java.springboot.address.mapper.AddressMapper.getById")),
            @Result(property = "goods",column = "orderSn",many = @Many(select = "com.how2java.springboot.order.mapper.OrderGoodsMapper.findGoodsByOrderSn"))
    })
    List<Order> findByPeiSongId(String id);
}
