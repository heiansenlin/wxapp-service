package com.how2java.springboot.coupon.mapper;

import com.how2java.springboot.coupon.entity.CouponType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CouponTypeMapper {
    @Select("select * from coupon_type_table where id =#{id}")
    CouponType getOneById(String id);

    @Select("select * from coupon_type_table where couponId = #{couponId}")
    List<CouponType> findAllByCouponId(String couponId);
}
