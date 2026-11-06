package com.cafuc.shopping.service;

import com.cafuc.shopping.bean.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author wh460
 * @since 2026-07-03
 */
public interface IPmsProductService extends IService<PmsProduct> {
    public List<PmsProduct> page(PmsProduct pmsProduct);
}
