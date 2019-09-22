package com.how2java.springboot.channel.service;

import com.how2java.springboot.channel.entity.ChannelPeople;

public interface ChannelPeopleService {
    ChannelPeople getByPeopleId(String id);
}
