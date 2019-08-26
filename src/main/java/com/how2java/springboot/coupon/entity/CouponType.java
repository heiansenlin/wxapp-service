package com.how2java.springboot.coupon.entity;

/**
 * 票券详细
 */
public class CouponType {
    private String id;          //主键
    private String couponId;    //票券主键
    private String name;        //详细名称
    private String num;         //抵顶数量
    private String money;       //票券金额
    private String str;         //详情描述
    private String delFlag;     //是否作废

    public CouponType(String id, String couponId, String name, String num, String money, String str, String delFlag) {
        this.id = id;
        this.couponId = couponId;
        this.name = name;
        this.num = num;
        this.money = money;
        this.str = str;
        this.delFlag = delFlag;
    }

    public CouponType() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
