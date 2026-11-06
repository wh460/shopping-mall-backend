package com.cafuc.shopping.controller;


import com.cafuc.shopping.bean.Goods;
import com.cafuc.shopping.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/goods")
@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Object getAll() {
        return goodsService.getGoodsAll("");
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getList(@RequestParam(defaultValue = "5") Integer pageSize,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          String name) {
        // 默认第一页开始、一行显示10个
        PageHelper.startPage(pageNum, pageSize);

// 原有的查询方法（需写在startpage后）
        List<Goods> goodsList = goodsService.getGoodsAll(name);

// pagehelper默认写法、传递session
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);

        return pageInfo.getList();
    }

    @RequestMapping(value = "/allinfo", method = RequestMethod.GET)
    public Object getAllInfo() {
        return goodsService.getGoodsAll(null);
    }

    @RequestMapping(value = "/obj", method = RequestMethod.GET)
    public Object getDetail(Integer id) {
        return goodsService.getById(id);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save(@RequestBody Goods goods) {
        return goodsService.insert(goods);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestBody Goods goods) {
        return goodsService.update(goods);
    }


    @RequestMapping("/del")
    public Object delete(Integer id) {
        return goodsService.deleteGoodsById(Integer.valueOf(id));
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Object delete(@RequestBody Goods goods) {
        return goodsService.deleteGoodsById(Integer.valueOf(goods.getId()));
    }


}
