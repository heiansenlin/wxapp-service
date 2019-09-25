package com.how2java.springboot.channel.mapper;

import com.how2java.springboot.channel.entity.ChannelPeople;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChannelPeopleMapper {

    @Select("select * from channel_people_table where userId = #{id}")
    ChannelPeople getByPeopleId(String id);

    @Select("select * from channel_people_table where channelId = #{channelId}")
    List<ChannelPeople> findByChannelId(String channelId);
}
