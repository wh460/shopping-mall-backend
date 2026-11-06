package com.cafuc.shopping.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafuc.shopping.bean.PmsProductCategory;
import com.cafuc.shopping.mapper.PmsProductCategoryMapper;
import com.cafuc.shopping.service.IPmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author wh460
 * @since 2026-07-06
 */
@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements IPmsProductCategoryService {
    @Autowired
    PmsProductCategoryMapper pmsProductCategoryMapper;
    @Override
    public List<PmsProductCategory> getNodeList() {
        List<PmsProductCategory> list = pmsProductCategoryMapper.selectList(null);
        List<Long> idList = new ArrayList<>();
        List<PmsProductCategory> nodeList = new ArrayList<>();
        list.stream().forEach(item -> {
            idList.add(item.getId());
        });
        list.stream().forEach(item -> {
            if (!idList.contains(item.getParentId())) {
                setChildren(list, item);
                nodeList.add(item);
            }
        });
        return nodeList;
    }

    /**
     * 递归调用
     * @param list
     * @param obj
     */
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

    /**
     * 获取子节点的数组
     * @param list
     * @param obj
     * @return
     */
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
