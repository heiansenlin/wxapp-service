package com.how2java.springboot.channel.entity;

/**
 * 渠道/门店
 */
public class Channel {
    private String id;
    private String name;    //名称
    private String address; //地址
    private String type;    //类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Channel() {
    }
}
