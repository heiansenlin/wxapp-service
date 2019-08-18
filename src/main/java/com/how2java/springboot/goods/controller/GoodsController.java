package com.how2java.springboot.goods.controller;

import com.how2java.springboot.goods.entity.Goods;
import com.how2java.springboot.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService service;

    @RequestMapping("/findAllByChannelId")
    @ResponseBody
    public List<Goods> findAllByChannelIdAndCategoryId(@RequestParam("channelId") String channelId,@RequestParam("categoryId") String categoryId){
        return service.findAllByChannelId(channelId,categoryId);
    }
}
