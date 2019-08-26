package com.how2java.springboot.coupon.mapper;

import com.how2java.springboot.coupon.entity.CouponTypeUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CouponTypeUserMapper {
    @Insert("insert into coupon_type_user_table (id,couponId,openId,goodsId,num,useNum,surNum,delFlag) " +
            "values (#{c.id},#{c.couponId},#{c.openId},#{c.goodsId},#{c.num},#{c.useNum},#{c.surNum},#{c.delFlag})")
    int save(CouponTypeUser c);

    @Select("select * from coupon_type_user_table where openId = #{openId} and goodsId = #{goodsId}")
    CouponTypeUser getByOpenIdAndGoodsId(String openId,String goodsId);
}
