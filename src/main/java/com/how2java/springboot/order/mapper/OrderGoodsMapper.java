package com.how2java.springboot.order.mapper;

import com.how2java.springboot.order.entity.OrderGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderGoodsMapper {

    @Insert("insert into order_goods_table (id,orderSn,goodsId,num,createTime) " +
            "values (#{o.id},#{o.orderSn},#{o.goodsId},#{o.num},#{o.createTime})")
    int save(@Param("o") OrderGoods orderGoods);
}
