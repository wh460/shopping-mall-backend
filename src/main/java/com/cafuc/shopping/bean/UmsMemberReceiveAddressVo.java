package com.cafuc.shopping.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;


/**
 * <p>
 * 会员收货地址表
 * </p>
 *
 * @author wh460
 * @since 2026-07-08
 */
@Getter
@Setter
public class UmsMemberReceiveAddressVo extends UmsMemberReceiveAddress {

    @TableField(exist = false)
    private String memberNickName;
}
