package com.cafuc.shopping.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cafuc.shopping.bean.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IUserService extends IService<SysUser> {

    List<SysUser> findAllUser();
}