package com.cafuc.shopping.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafuc.shopping.bean.Goods;
import com.cafuc.shopping.config.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @Author wh460
 * @Date 22/3/23
 */

//@CacheNamespace(implementation = MybatisRedisCache.class)
public interface GoodsMapper extends BaseMapper<Goods> {

    List<Goods> getGoodsAll(String name);
    Integer insertGoods(Goods goods);
    Integer updateGoods(Goods goods);
    Integer deleteGoodsById(Integer id);

}