package com.cafuc.shopping.mapper;

import com.cafuc.shopping.bean.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafuc.shopping.config.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author wh460
 * @since 2026-07-03
 */
//@CacheNamespace(implementation = MybatisRedisCache.class)
public interface PmsProductMapper extends BaseMapper<PmsProduct> {
    public List<PmsProduct> page(PmsProduct pmsProduct);

}
