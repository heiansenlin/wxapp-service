package com.how2java.springboot.categories.mapper;

import com.how2java.springboot.categories.entity.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoriesMapper {

    @Select("select * from categories_table where channelId = #{channelId}")
    List<Categories> findAllByChannelId(String channelId);
}
