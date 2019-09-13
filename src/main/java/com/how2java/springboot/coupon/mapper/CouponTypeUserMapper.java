package com.how2java.springboot.coupon.mapper;

import com.how2java.springboot.coupon.entity.CouponTypeUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CouponTypeUserMapper {
    @Insert("insert into coupon_type_user_table (id,couponId,openId,goodsId,money,num,useNum,surNum,delFlag) " +
            "values (#{c.id},#{c.couponId},#{c.openId},#{c.goodsId},#{c.money},#{c.num},#{c.useNum},#{c.surNum},#{c.delFlag})")
    int save(@Param("c") CouponTypeUser c);

    @Select("select * from coupon_type_user_table where openId = #{openId} and goodsId = #{goodsId} and delFlag = '0'")
    CouponTypeUser getByOpenIdAndGoodsId(@Param("openId") String openId,@Param("goodsId") String goodsId);

    @Update("update coupon_type_user_table set surNum = #{surNum} , num = #{num},money = #{money} where id = #{id}")
    int updateNum(@Param("surNum") String surNum,@Param("num") String num,@Param("money") String money,@Param("id")String id);

    @Update("update coupon_type_user_table set delFlag = 1 where id = #{id}")
    int delete(String id);
}
