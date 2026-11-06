package com.cafuc.shopping.service.impl;

/**
 * @Author wh460
 * @Date 22/3/23
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafuc.shopping.bean.Goods;
import com.cafuc.shopping.mapper.GoodsMapper;
import com.cafuc.shopping.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsAll(String name) {
        return goodsMapper.getGoodsAll(name);
    }

    @Override
    public Integer insert(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public Integer deleteGoodsById(Integer id) {
        return goodsMapper.deleteGoodsById(id);
    }
}