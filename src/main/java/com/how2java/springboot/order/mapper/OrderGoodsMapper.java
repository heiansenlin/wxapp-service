package com.how2java.springboot.order.mapper;

import com.how2java.springboot.goods.entity.Goods;
import com.how2java.springboot.order.entity.OrderGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderGoodsMapper {

    @Insert("insert into order_goods_table (id,orderSn,goodsId,num,createTime) " +
            "values (#{o.id},#{o.orderSn},#{o.goodsId},#{o.num},#{o.createTime})")
    int save(@Param("o") OrderGoods orderGoods);

    @Select("select t.* from goods_table t left join order_goods_table t1 on t.id = t1.goodsId where t1.orderSn = #{sn}")
    List<Goods> findGoodsByOrderSn(String sn);
}
