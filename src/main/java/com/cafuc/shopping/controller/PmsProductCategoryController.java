package com.cafuc.shopping.controller;

import com.cafuc.shopping.bean.PmsProductCategory;
import com.cafuc.shopping.service.IPmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 产品分类 前端控制器
 * </p>
 *
 * @author wh460
 * @since 2026-07-06
 */
@RestController
@RequestMapping("/pmsProductCategory")
public class PmsProductCategoryController {
    @Autowired
    IPmsProductCategoryService pmsProductCategoryService;

    @GetMapping("/getNodeList")
    public List<PmsProductCategory> getNodeList() {
        return pmsProductCategoryService.getNodeList();
    }
}
