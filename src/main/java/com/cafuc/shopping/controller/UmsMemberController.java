package com.cafuc.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cafuc.shopping.bean.UmsAdminLoginParam;
import com.cafuc.shopping.bean.UmsMember;
import com.cafuc.shopping.common.CommonResult;
import com.cafuc.shopping.service.IUmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author wh460
 * @since 2026-07-07
 */
@RestController
@RequestMapping("/umsMember")
public class UmsMemberController {

    @Autowired
    IUmsMemberService umsMemberService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        QueryWrapper<UmsMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", umsAdminLoginParam.getUsername());
        queryWrapper.eq("password", umsAdminLoginParam.getPassword());
        UmsMember umsMember = umsMemberService.getOne(queryWrapper);
        if(umsMember != null && umsMember.getId()!=null) {
            umsMember.setPassword(null);
            HashMap<String, Object> map = new HashMap<>();
            map.put("data", umsMember);
            map.put("code", 200);
            map.put("msg", "操作成功!");
//            return  map ;
            return  CommonResult.success(umsMember) ;
        }else {
            return CommonResult.failed("用户名或密码不存在");
        }
    }

}
