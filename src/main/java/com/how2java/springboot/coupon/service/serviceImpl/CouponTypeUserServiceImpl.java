package com.how2java.springboot.coupon.service.serviceImpl;

import com.how2java.springboot.coupon.entity.Coupon;
import com.how2java.springboot.coupon.entity.CouponType;
import com.how2java.springboot.coupon.entity.CouponTypeUser;
import com.how2java.springboot.coupon.mapper.CouponTypeUserMapper;
import com.how2java.springboot.coupon.service.CouponService;
import com.how2java.springboot.coupon.service.CouponTypeService;
import com.how2java.springboot.coupon.service.CouponTypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CouponTypeUserServiceImpl implements CouponTypeUserService {
    @Autowired
    private CouponTypeUserMapper mapper;
    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponTypeService couponTypeService;
    @Override
    public int save(String couponId,String couponTypeId, String openId) {
        CouponTypeUser couponTypeUser = new CouponTypeUser();
        Coupon oneById = couponService.getOneById(couponId);
        CouponType oneById1 = couponTypeService.getOneById(couponTypeId);
        couponTypeUser.setId(UUID.randomUUID().toString());
        couponTypeUser.setCouponId(oneById.getId());
        couponTypeUser.setGoodsId(oneById.getGoodsId());
        couponTypeUser.setOpenId(openId);
        couponTypeUser.setNum(oneById1.getNum());
        couponTypeUser.setUseNum("0");
        couponTypeUser.setSurNum(oneById1.getNum());
        couponTypeUser.setDelFlag("0");
        return mapper.save(couponTypeUser);
    }
}
