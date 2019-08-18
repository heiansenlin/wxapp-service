package com.how2java.springboot.channel.mapper;

import com.how2java.springboot.channel.entity.Channel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChannelMapper {

    @Select("select * from channel_table where type = #{type}")
    List<Channel> findAllByType(String type);
}
