package com.how2java.springboot.goods.service.serviceImpl;

import com.how2java.springboot.goods.entity.Goods;
import com.how2java.springboot.goods.mapper.GoodsMapper;
import com.how2java.springboot.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper mapper;
    @Override
    public List<Goods> findAllByChannelId(String channelId,String categoryId) {
        return mapper.findAllByChannelId(channelId,categoryId);
    }
}
