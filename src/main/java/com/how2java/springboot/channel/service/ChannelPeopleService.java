package com.how2java.springboot.channel.service;

import com.how2java.springboot.channel.entity.ChannelPeople;

import java.util.List;

public interface ChannelPeopleService {
    ChannelPeople getByPeopleId(String id);
    List<ChannelPeople> findByChannelId(String channelId);
}
