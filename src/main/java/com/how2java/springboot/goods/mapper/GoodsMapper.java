package com.how2java.springboot.goods.mapper;

import com.how2java.springboot.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select t2.* from channel_goods_table t LEFT JOIN goods_table t2 ON t.goodsId = t2.id where t.channelId = #{channelId} AND t.categoryId = #{categoryId}")
    List<Goods> findAllByChannelId(@Param("channelId") String channelId,@Param("categoryId") String categoryId);

    @Select("select * from goods_table where id = #{goodsId}")
    Goods getByGoodsId(String goodsId);
}
