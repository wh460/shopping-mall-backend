package com.cafuc.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cafuc.shopping.bean.Customer;
import com.cafuc.shopping.bean.SysUser;
import com.cafuc.shopping.mapper.CustomerMapper;
import com.cafuc.shopping.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    ICustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/list")
    public  Object getAll(){
        return customerService.getById(1);
    }



    @GetMapping("/groupByCreator")
    public  Object groupByCreator(){
        QueryWrapper<Customer> qw = new QueryWrapper<>();
        qw.select("creator, count(*)").groupBy("creator");
        List<Map<String,Object>> list = customerMapper.selectMaps(qw);
        return list;
    }


    @GetMapping("/page")
    public  Object page(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer pageSize){
        QueryWrapper qw = new QueryWrapper<>(null);
        Page ps = new Page<Customer>(pageNum, pageSize);
        IPage<Customer> list = customerService.page(ps,qw);
        return list;
    }


    @PostMapping("/save")
    public  Object save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PostMapping("/update")
    public  Object update(@RequestBody Customer customer){
        return customerService.updateById(customer);
    }

    @PostMapping("/saveOrUpdate")
    public  Object saveOrUpdate(@RequestBody Customer customer){
        return customerService.saveOrUpdate(customer);
    }

}
