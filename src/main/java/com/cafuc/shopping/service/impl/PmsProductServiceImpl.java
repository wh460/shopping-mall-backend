package com.cafuc.shopping.service.impl;

import com.cafuc.shopping.bean.PmsProduct;
import com.cafuc.shopping.mapper.PmsProductMapper;
import com.cafuc.shopping.service.IPmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author wh460
 * @since 2026-07-03
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements IPmsProductService {

    @Autowired
   PmsProductMapper pmsProductMapper;
    @Override
    public List<PmsProduct> page(PmsProduct pmsProduct) {
        return pmsProductMapper.page(pmsProduct);
    }
}
