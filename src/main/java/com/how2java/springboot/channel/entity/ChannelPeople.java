package com.how2java.springboot.channel.entity;

/**
 * 门店员工
 */
public class ChannelPeople {
    private String id;          //主键
    private String channelId;   //门店主键
    private String userId;      //员工主键
    private String delFlag;     //是否删除

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
