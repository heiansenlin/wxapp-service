package com.how2java.springboot.coupon.controller;

import com.how2java.springboot.coupon.entity.Coupon;
import com.how2java.springboot.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService service;

    @RequestMapping("/findAllByChannelId")
    @ResponseBody
    public List<Coupon> findAllByChannelId(@RequestParam("channelId") String channelId){
        return service.findAllByChannelId(channelId);
    }
}
