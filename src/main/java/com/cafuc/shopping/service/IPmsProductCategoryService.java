package com.cafuc.shopping.service;

import com.cafuc.shopping.bean.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author wh460
 * @since 2026-07-06
 */
public interface IPmsProductCategoryService extends IService<PmsProductCategory> {
    public List<PmsProductCategory> getNodeList();

}
