package com.how2java.springboot.coupon.mapper;

import com.how2java.springboot.coupon.entity.Coupon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CouponMapper {

    @Select("select * from coupon_table t where t.channelId = #{channelId}")
    @Results(
        @Result(property = "couponType",column = "couponType",javaType = List.class,many = @Many(select="com.how2java.springboot.coupon.mapper.CouponTypeMapper.findAllByCouponId"))
    )
    List<Coupon> findAllByChannelId(String channelId);

    @Select("select * from coupon_table where id = #{id}")
    Coupon getOneById(String id);
}
