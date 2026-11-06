package com.cafuc.shopping.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cafuc.shopping.bean.SysUser;
import com.cafuc.shopping.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private IUserService userService;

    @GetMapping("/getUser")
    public SysUser getUser(){
        return userService.getById(2);
    }

    /**
     * 分页例子
     * @return
     */
    @GetMapping("/list")
    public Object getList(){
        QueryWrapper qw = new QueryWrapper<>(null);
        Page ps = new Page<SysUser>(1, 5);
        IPage<SysUser> u = userService.page(ps,qw);
        return u;
    }

    @GetMapping("/findAllUser")
    public List<SysUser> findAllUser(){
        return userService.findAllUser();
    }
}