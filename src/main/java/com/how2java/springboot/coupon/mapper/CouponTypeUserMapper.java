package com.how2java.springboot.coupon.mapper;

import com.how2java.springboot.coupon.entity.CouponTypeUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CouponTypeUserMapper {
    @Insert("insert into coupon_type_user_table (id,couponId,openId,goodsId,money,num,useNum,surNum,delFlag) " +
            "values (#{c.id},#{c.couponId},#{c.openId},#{c.goodsId},#{c.money},#{c.num},#{c.useNum},#{c.surNum},#{c.delFlag})")
    int save(@Param("c") CouponTypeUser c);

    @Select("select * from coupon_type_user_table where openId = #{openId} and goodsId = #{goodsId}")
    CouponTypeUser getByOpenIdAndGoodsId(@Param("openId") String openId,@Param("goodsId") String goodsId);
}
