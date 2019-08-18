package com.how2java.springboot.channel.service.serviceImpl;

import com.how2java.springboot.channel.entity.Channel;
import com.how2java.springboot.channel.mapper.ChannelMapper;
import com.how2java.springboot.channel.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelMapper mapper;
    @Override
    public List<Channel> findAllByType(String type) {
        return mapper.findAllByType(type);
    }
}
