package com.cafuc.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cafuc.shopping.bean.PmsProduct;
import com.cafuc.shopping.bean.PmsProductImages;
import com.cafuc.shopping.service.IPmsBrandService;
import com.cafuc.shopping.service.IPmsProductImagesService;
import com.cafuc.shopping.service.IPmsProductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author wh460
 * @since 2026-07-03
 */
@RestController
@RequestMapping("/product")
public class PmsProductController {

    @Autowired
    IPmsProductService pmsProductService;

    @Autowired
    IPmsBrandService brandService;

    @Autowired
    IPmsProductImagesService pmsProductImagesService;

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Object page(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       @RequestParam(defaultValue = "null") String name ) {
        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        if(name!=null){
            //queryWrapper.like("name",name);
        }
        queryWrapper.orderByDesc("id");
        Page<PmsProduct> page = new Page<PmsProduct>(pageNum,pageSize);
        IPage<PmsProduct> pages = pmsProductService.page(page,queryWrapper);
        List<PmsProduct> ProductsList = pages.getRecords();
        ProductsList.stream().forEach(item->{
            item.setProductImages(this.getList(item.getId(),1));
            item.setProductDetailImages(this.getList(item.getId(),2));
        });
        return pages;
    }

    private List<String> getList(Long productId,Integer typeId){
        QueryWrapper<PmsProductImages> queryWrapper = new QueryWrapper<>();
        if(productId!=null){
            queryWrapper.eq("product_id",productId);
        }
        queryWrapper.eq(typeId!=null,"typeId",typeId);
        List<PmsProductImages> list = pmsProductImagesService.list(queryWrapper);
        List<String> imageList = new ArrayList<>();
        list.stream().forEach(item->{
            imageList.add(item.getPic());
        });
        return imageList;
    }

    @RequestMapping(value = "/pagesize",method = RequestMethod.GET)
    public Object pagesize(){
        PmsProduct pmsProduct=null;
        return pmsProductService.page(pmsProduct);
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Object upload(@RequestBody PmsProduct pmsProduct){
        return pmsProductService.updateById(pmsProduct);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object delete(@RequestParam Integer id){
        return pmsProductService.removeById(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(@RequestBody PmsProduct pmsProduct){
        return pmsProductService.save(pmsProduct);
    }


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Object get(@RequestParam Integer id){
        return pmsProductService.getById(id);}

}
