package com.cafuc.shopping.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wh460
 * @since 2026-07-13
 */
@Getter
@Setter
@TableName("pms_product_images")
public class PmsProductImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    @TableField("product_id")
    private Integer productId;

    /**
     * 商品图片地址
     */
    @TableField("pic")
    private String pic;

    /**
     * 1商品图片， 2商品详情
     */
    @TableField("typeId")
    private Integer typeId;
}
