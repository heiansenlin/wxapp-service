package com.how2java.springboot.order.entity;

import com.how2java.springboot.address.entity.Address;
import com.how2java.springboot.goods.entity.Goods;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单
 */
public class Order {
    private String id;          //主键
    private String orderSn;     //订单编号
    private String userId;      //userId
    private String peiSongId;   //配送人员Id
    private String channelId;   //门店主键
    private String addressId;   //地址主键
    private String couponId;    //票券主键
    private String money;       //总金额
    private String state;       //订单状态
    private LocalDateTime createTime;  //创建时间
    private Address address;
    private List<Goods> goods;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPeiSongId() {
        return peiSongId;
    }

    public void setPeiSongId(String peiSongId) {
        this.peiSongId = peiSongId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
