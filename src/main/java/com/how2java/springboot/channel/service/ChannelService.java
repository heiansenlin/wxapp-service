package com.how2java.springboot.channel.service;

import com.how2java.springboot.channel.entity.Channel;

import java.util.List;

public interface ChannelService {
    List<Channel> findAllByType(String type);
}
