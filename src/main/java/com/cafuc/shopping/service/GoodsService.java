package com.cafuc.shopping.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cafuc.shopping.bean.Goods;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author wh460
 * @Date 22/3/23
 */
public interface GoodsService extends IService<Goods> {
    List<Goods> getGoodsAll(String name);
    Integer insert(Goods goods);
    Integer update(Goods goods);
    Integer deleteGoodsById(Integer id);
}