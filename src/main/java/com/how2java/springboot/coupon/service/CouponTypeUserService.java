package com.how2java.springboot.coupon.service;

import java.util.List;
import java.util.Map;

public interface CouponTypeUserService {
    /**
     * 保存票券详细信息：没有生成；有增加次数
     * @param couponId
     * @param couponTypeId
     * @param openId
     * @param money
     * @return
     */
    int save(String couponId,String couponTypeId,String openId,String money);

    /**
     * 根据用户主键和全部商品主键查询相关的票券
     * @param openId
     * @param goodsIds
     * @return
     */
    List<Map<String, String>> getByOpenIdAndGoodsId(String openId, String goodsIds);

    /**
     * 修改票券剩余次数
     * @param num 总次数
     * @param surNum 剩余次数
     * @param money 购入价格
     * @param id  主键
     * @return
     */
    int updateNum(String surNum,String num,String money,String id);

    /**
     * 作废无剩余使用次数的票券
     * @param id
     * @return
     */
    int delete(String id);
}
