package com.cafuc.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cafuc.shopping.bean.OmsCartItem;
import com.cafuc.shopping.bean.PmsProduct;
import com.cafuc.shopping.service.IOmsCartItemService;
import com.cafuc.shopping.service.IPmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author wh460
 * @since 2026-07-14
 */
@RestController
@RequestMapping("/omsCartItem")
public class OmsCartItemController {
    @Autowired
    IOmsCartItemService omsCartItemService;

    @Autowired
    IPmsProductService pmsProductService;

    @PostMapping("/save")
    public Object save(@RequestBody OmsCartItem omsCartItem){
        LocalDateTime now = LocalDateTime.now();
        omsCartItem.setCreateDate(now);
        return omsCartItemService.save(omsCartItem);
    }

    @GetMapping("/list")
    public Object list(Long memberId){
        QueryWrapper<OmsCartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(memberId!=null, "member_id", memberId);
        List<OmsCartItem> list = omsCartItemService.list(queryWrapper);
        list.stream().forEach(item->{
            PmsProduct pmsProduct = pmsProductService.getById(item.getProductId());
            item.setPmsProduct(pmsProduct);
        });
          return list;
    }

}
