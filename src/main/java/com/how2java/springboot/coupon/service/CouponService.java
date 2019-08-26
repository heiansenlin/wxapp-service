package com.how2java.springboot.coupon.service;

import com.how2java.springboot.coupon.entity.Coupon;

import java.util.List;

public interface CouponService {
    /**
     * 根据门店Id查询全部票券信息
     * @param channelId 门店id
     * @return list
     */
    List<Coupon> findAllByChannelId(String channelId);

    /**
     * 根据主键查询票券
     * @param id 主键
     * @return Coupon
     */
    Coupon getOneById(String id);
}
