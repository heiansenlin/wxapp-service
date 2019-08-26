package com.how2java.springboot.coupon.mapper;

import com.how2java.springboot.coupon.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CouponMapper {

    @Select("select * from coupon_table left t join coupon_type_table t1 on t.id = t1.couponId where channelId = #{channelId}")
    List<Coupon> findAllByChannelId(String channelId);

    @Select("select * from coupon_table where id = #{id}")
    Coupon getOneById(String id);
}
