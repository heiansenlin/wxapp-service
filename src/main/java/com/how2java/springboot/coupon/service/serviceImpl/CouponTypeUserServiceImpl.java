package com.how2java.springboot.coupon.service.serviceImpl;

import com.how2java.springboot.coupon.entity.Coupon;
import com.how2java.springboot.coupon.entity.CouponType;
import com.how2java.springboot.coupon.entity.CouponTypeUser;
import com.how2java.springboot.coupon.mapper.CouponTypeUserMapper;
import com.how2java.springboot.coupon.service.CouponService;
import com.how2java.springboot.coupon.service.CouponTypeService;
import com.how2java.springboot.coupon.service.CouponTypeUserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;


@Service
public class CouponTypeUserServiceImpl implements CouponTypeUserService {
    @Autowired
    private CouponTypeUserMapper mapper;
    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponTypeService couponTypeService;
    @Override
    public int save(String couponId,String couponTypeId, String openId,String money) {
        CouponTypeUser couponTypeUser = new CouponTypeUser();
        Coupon oneById = couponService.getOneById(couponId);
        CouponType oneById1 = couponTypeService.getOneById(couponTypeId);
        CouponTypeUser byOpenIdAndGoodsId = mapper.getByOpenIdAndGoodsId(openId, oneById.getGoodsId());
        if (byOpenIdAndGoodsId!=null){
            //剩余次数
            BigDecimal add = new BigDecimal(byOpenIdAndGoodsId.getSurNum()).add(new BigDecimal(oneById1.getNum()));
            //总次数
            BigDecimal add2 = new BigDecimal(byOpenIdAndGoodsId.getNum()).add(new BigDecimal(oneById1.getNum()));
            //总金额
            BigDecimal add3 = new BigDecimal(byOpenIdAndGoodsId.getMoney()).add(new BigDecimal(oneById1.getMoney()));
            return updateNum(add.toString(),add2.toString(),add3.toString(),byOpenIdAndGoodsId.getId());
        }else {
            couponTypeUser.setId(UUID.randomUUID().toString());
            couponTypeUser.setCouponId(oneById.getId());
            couponTypeUser.setCouponName(oneById.getName());
            couponTypeUser.setGoodsId(oneById.getGoodsId());
            couponTypeUser.setMoney(money);
            couponTypeUser.setOpenId(openId);
            couponTypeUser.setNum(oneById1.getNum());
            couponTypeUser.setUseNum("0");
            couponTypeUser.setSurNum(oneById1.getNum());
            couponTypeUser.setDelFlag("0");
            return mapper.save(couponTypeUser);
        }
    }

    @Override
    public List<Map<String, String>> getByOpenIdAndGoodsId(String openId, String goodsIds) {
        goodsIds = goodsIds.substring(0,goodsIds.length()-1);
        String[] split = goodsIds.split(",");
        ArrayList<CouponTypeUser> couponTypeUsers = new ArrayList<>();
        ArrayList<Map<String, String>> maps = new ArrayList<>();
        for (String s:split){
            CouponTypeUser byOpenIdAndGoodsId = mapper.getByOpenIdAndGoodsId(openId, goodsIds);
            if (byOpenIdAndGoodsId!=null){
                couponTypeUsers.add(byOpenIdAndGoodsId);
            }
        }
        for (CouponTypeUser c:couponTypeUsers){
            Coupon oneById = couponService.getOneById(c.getCouponId());
            HashMap<String, String> map = new HashMap<>();
            map.put("name",oneById.getName());
            map.put("seNum",c.getSurNum());
            map.put("num",c.getNum());
            map.put("money",c.getMoney());
            map.put("goodsId",c.getGoodsId());
            map.put("couponTypeId",c.getId());
            map.put("couponId",c.getCouponId());
            maps.add(map);
        }
        return maps;
    }

    @Override
    public int updateNum(String surNum,String num,String money,String id) {
        return mapper.updateNum(surNum, num, money, id);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }
}
