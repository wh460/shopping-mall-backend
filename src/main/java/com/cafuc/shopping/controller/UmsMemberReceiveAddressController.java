package com.cafuc.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cafuc.shopping.bean.UmsMember;
import com.cafuc.shopping.bean.UmsMemberReceiveAddressVo;
import com.cafuc.shopping.service.IUmsMemberReceiveAddressService;
import com.cafuc.shopping.service.IUmsMemberService;
import com.cafuc.shopping.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 会员收货地址表 前端控制器
 * </p>
 *
 * @author wh460
 * @since 2026-07-08
 */
@RestController
@RequestMapping("/umsMemberReceiveAddress")
public class UmsMemberReceiveAddressController {

    @Autowired
    IUmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @Autowired
    IUmsMemberService umsMemberService;

    @Autowired
    RedisService redisService;

    @GetMapping("/getListByMemberId")
    public Object getAll(@RequestParam Integer memberId){
        UmsMemberReceiveAddressVo v = new UmsMemberReceiveAddressVo();
        QueryWrapper<UmsMemberReceiveAddressVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id", memberId);
        List<UmsMemberReceiveAddressVo> list = umsMemberReceiveAddressService.list(queryWrapper);
        List<UmsMemberReceiveAddressVo> newlist = new ArrayList<>();
        list.stream().forEach(item->{
            UmsMember umsMember = umsMemberService.getById(item.getMemberId());
            item.setMemberNickName(umsMember.getNickname());
            newlist.add(item);
        });
        return newlist;
    }



    @GetMapping("/getListByMemberIdByRedis")
    public Object getListByRedis(@RequestParam Integer memberId){
        UmsMemberReceiveAddressVo v = new UmsMemberReceiveAddressVo();
        QueryWrapper<UmsMemberReceiveAddressVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id", memberId);
        List<UmsMemberReceiveAddressVo> list = umsMemberReceiveAddressService.list(queryWrapper);
        List<UmsMemberReceiveAddressVo> newlist = new ArrayList<>();
        list.stream().forEach(item->{
            String memberNickName = redisService.get(memberId.toString());
            if(memberNickName==null){
                UmsMember umsMember = umsMemberService.getById(item.getMemberId());
                item.setMemberNickName(umsMember.getNickname());
                redisService.set(umsMember.getId().toString(),umsMember.getNickname());
            }else {
                item.setMemberNickName(memberNickName);
            }
            newlist.add(item);
        });
        return newlist;
    }


}
