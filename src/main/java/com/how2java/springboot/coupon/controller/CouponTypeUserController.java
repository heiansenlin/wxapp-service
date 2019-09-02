package com.how2java.springboot.coupon.controller;

import com.how2java.springboot.coupon.service.CouponTypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/couponTypeUser")
public class CouponTypeUserController {
    @Autowired
    private CouponTypeUserService couponTypeUserService;

    @RequestMapping("/save")
    @ResponseBody
    public int save(
            @RequestParam("couponId") String couponId,
            @RequestParam("couponTypeId") String couponTypeId,
            @RequestParam("userId") String userId,
            @RequestParam("money")String money){
        return couponTypeUserService.save(couponId, couponTypeId, userId,money);
    }

    @RequestMapping("/getByOpenIdAndGoodsId")
    @ResponseBody
        public List<Map<String, String>> getByOpenIdAndGoodsId(@RequestParam("openId") String openId,@RequestParam("goodsIds") String goodsIds){
        return couponTypeUserService.getByOpenIdAndGoodsId(openId, goodsIds);
    }
}
