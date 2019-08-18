package com.how2java.springboot.categories.service;

import com.how2java.springboot.categories.entity.Categories;

import java.util.List;

public interface CategoriesServie {
    List<Categories> findAllByChannelId(String channelId);
}
