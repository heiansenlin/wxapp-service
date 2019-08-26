package com.how2java.springboot.coupon.service.serviceImpl;

import com.how2java.springboot.coupon.entity.CouponType;
import com.how2java.springboot.coupon.mapper.CouponTypeMapper;
import com.how2java.springboot.coupon.service.CouponTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponTypeServiceImpl implements CouponTypeService {
    @Autowired
    private CouponTypeMapper mapper;
    @Override
    public CouponType getOneById(String id) {
        return mapper.getOneById(id);
    }
}
