package com.how2java.springboot.categories.controller;

import com.how2java.springboot.categories.entity.Categories;
import com.how2java.springboot.categories.service.CategoriesServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesServie servie;

    @RequestMapping("/findAllByChannelId")
    @ResponseBody
    public List<Categories> findAllByChannelId(String channelId){
        return servie.findAllByChannelId(channelId);
    }
}
