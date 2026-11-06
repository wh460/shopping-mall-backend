package com.cafuc.shopping.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafuc.shopping.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


public interface SysUserMapper extends BaseMapper<SysUser> {

    public List<SysUser> findAllUser();
}