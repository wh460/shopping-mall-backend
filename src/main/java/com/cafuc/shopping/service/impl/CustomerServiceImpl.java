package com.cafuc.shopping.service.impl;

import com.cafuc.shopping.bean.Customer;
import com.cafuc.shopping.mapper.CustomerMapper;
import com.cafuc.shopping.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wh460
 * @since 2026-07-02
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
