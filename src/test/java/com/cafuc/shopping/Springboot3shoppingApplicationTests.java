package com.cafuc.shopping;

import com.cafuc.shopping.bean.PmsProduct;
import com.cafuc.shopping.bean.PmsProductCategory;
import com.cafuc.shopping.service.IPmsProductCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Springboot3shoppingApplicationTests {

    @Autowired
    IPmsProductCategoryService iPmsProductCategoryService;

    @Test
    void contextLoads() {
        List<PmsProductCategory> list = iPmsProductCategoryService.list();
        List<Long> idList = new ArrayList<>();
        List<PmsProductCategory> nodeList = new ArrayList<>();
        list.stream().forEach(item -> {
            idList.add(item.getId());
        });
        list.stream().forEach(item -> {
           if (!idList.contains(item.getId())) {
               setChildren(list, item);
               nodeList.add(item);
           }
        });
        System.out.println(nodeList);
    }

    private void setChildren(List<PmsProductCategory> list, PmsProductCategory obj) {
        List<PmsProductCategory> childList = getChildList(list,obj);
        obj.setChildren(childList);
        childList.stream().forEach(item -> {
            //判断对象是否有子分类
            if (getChildList(list,item).size()>0) {
                setChildren(list,item);
            }
        });
    }

    private List<PmsProductCategory> getChildList(List<PmsProductCategory> list, PmsProductCategory obj) {
        List<PmsProductCategory> childList = new ArrayList<>();
        list.stream().forEach(item -> {
            if (item.getParentId().equals(obj.getId())) {
                childList.add(item);
            }
        });
        return childList;
    }

}
