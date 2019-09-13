package com.how2java.springboot.coupon.entity;

/**
 * 用户票券详情表
 */
public class CouponTypeUser {
    private String id;          //主键
    private String couponId;    //票券id
    private String couponName;  //票券名称
    private String openId;      //用户openid
    private String goodsId;     //商品主键
    private String money;       //购入价格
    private String num;         //总抵顶次数
    private String useNum;      //使用次数
    private String surNum;      //剩余次数
    private String delFlag;     //是否作废

    public CouponTypeUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUseNum() {
        return useNum;
    }

    public void setUseNum(String useNum) {
        this.useNum = useNum;
    }

    public String getSurNum() {
        return surNum;
    }

    public void setSurNum(String surNum) {
        this.surNum = surNum;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
