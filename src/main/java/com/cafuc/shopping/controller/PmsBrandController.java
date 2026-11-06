package com.cafuc.shopping.controller;

import com.cafuc.shopping.service.IPmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author wh460
 * @since 2026-07-07
 */
@RestController
@RequestMapping("/pmsBrand")
public class PmsBrandController {
    @Autowired
    IPmsBrandService brandService;

    @GetMapping("/list")
    public Object list() {
        return brandService.list();
    }

}
