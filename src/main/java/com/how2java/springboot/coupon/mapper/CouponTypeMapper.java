package com.how2java.springboot.coupon.mapper;

import com.how2java.springboot.coupon.entity.CouponType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CouponTypeMapper {
    @Select("select * from coupon_type_table where id =#{id}")
    CouponType getOneById(String id);
}
