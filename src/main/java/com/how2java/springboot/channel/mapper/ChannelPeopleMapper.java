package com.how2java.springboot.channel.mapper;

import com.how2java.springboot.channel.entity.ChannelPeople;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChannelPeopleMapper {

    @Select("select * from channel_people_table where userId = #{id}")
    ChannelPeople getByPeopleId(String id);
}
