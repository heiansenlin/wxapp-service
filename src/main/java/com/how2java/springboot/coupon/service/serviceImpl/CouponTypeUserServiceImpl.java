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
        couponTypeUser.setId(UUID.randomUUID().toString());
        couponTypeUser.setCouponId(oneById.getId());
        couponTypeUser.setGoodsId(oneById.getGoodsId());
        couponTypeUser.setMoney(money);
        couponTypeUser.setOpenId(openId);
        couponTypeUser.setNum(oneById1.getNum());
        couponTypeUser.setUseNum("0");
        couponTypeUser.setSurNum(oneById1.getNum());
        couponTypeUser.setDelFlag("0");
        return mapper.save(couponTypeUser);
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
            map.put("goodsId",c.getGoodsId());
            map.put("couponTypeId",c.getId());
            maps.add(map);
        }
        return maps;
    }
}
