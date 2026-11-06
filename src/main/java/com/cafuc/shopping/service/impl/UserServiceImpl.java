package com.cafuc.shopping.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafuc.shopping.bean.SysUser;
import com.cafuc.shopping.mapper.SysUserMapper;
import com.cafuc.shopping.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements IUserService {

    @Resource
    private SysUserMapper userMapper;
    @Override
    public List<SysUser> findAllUser() {
        return userMapper.findAllUser();
    }
}