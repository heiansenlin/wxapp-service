package com.how2java.springboot.coupon.service;

import java.util.List;
import java.util.Map;

public interface CouponTypeUserService {
    int save(String couponId,String couponTypeId,String openId,String money);
    List<Map<String, String>> getByOpenIdAndGoodsId(String openId, String goodsIds);
}
