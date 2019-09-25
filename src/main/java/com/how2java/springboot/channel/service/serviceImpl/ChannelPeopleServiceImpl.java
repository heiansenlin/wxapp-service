package com.how2java.springboot.channel.service.serviceImpl;

import com.how2java.springboot.channel.entity.ChannelPeople;
import com.how2java.springboot.channel.mapper.ChannelPeopleMapper;
import com.how2java.springboot.channel.service.ChannelPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelPeopleServiceImpl implements ChannelPeopleService {
    @Autowired
    private ChannelPeopleMapper mapper;
    @Override
    public ChannelPeople getByPeopleId(String id) {
        return mapper.getByPeopleId(id);
    }

    @Override
    public List<ChannelPeople> findByChannelId(String channelId) {
        return mapper.findByChannelId(channelId);
    }
}
