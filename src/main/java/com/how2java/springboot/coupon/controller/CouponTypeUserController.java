package com.how2java.springboot.coupon.controller;

import com.how2java.springboot.coupon.service.CouponTypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/couponType")
public class CouponTypeUserController {
    @Autowired
    private CouponTypeUserService couponTypeUserService;

    @RequestMapping("/save")
    @ResponseBody
    public int save(@RequestParam("couponId") String couponId,@RequestParam("couponTypeId") String couponTypeId,@RequestParam("openId") String openId){
        return couponTypeUserService.save(couponId, couponTypeId, openId);
    }
}
