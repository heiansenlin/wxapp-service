package com.how2java.springboot.coupon.service.serviceImpl;

import com.how2java.springboot.coupon.entity.Coupon;
import com.how2java.springboot.coupon.mapper.CouponMapper;
import com.how2java.springboot.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper mapper;
    @Override
    public List<Coupon> findAllByChannelId(String channelId) {
        return mapper.findAllByChannelId(channelId);
    }

    @Override
    public Coupon getOneById(String id) {
        return mapper.getOneById(id);
    }
}
