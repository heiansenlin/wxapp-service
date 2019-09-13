package com.how2java.springboot.goods.service;

import com.how2java.springboot.goods.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> findAllByChannelId(String channelId,String categoryId);

    Goods getByGoodsId(String goodsId);
}
