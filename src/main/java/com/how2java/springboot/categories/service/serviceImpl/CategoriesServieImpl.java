package com.how2java.springboot.categories.service.serviceImpl;

import com.how2java.springboot.categories.entity.Categories;
import com.how2java.springboot.categories.mapper.CategoriesMapper;
import com.how2java.springboot.categories.service.CategoriesServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServieImpl implements CategoriesServie {
    @Autowired
    private CategoriesMapper mapper;
    @Override
    public List<Categories> findAllByChannelId(String channelId) {
        return mapper.findAllByChannelId(channelId);
    }
}
