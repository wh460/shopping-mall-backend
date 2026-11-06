package com.cafuc.shopping.bean;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;


/**
 * @Author wh460
 * @Date 22/4/1
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;


    // @TableId(value = "id", type = IdType.ID_WORKER)
    /**
     * 雪花算法 生成数字类型的全局唯一id
     * 用途：分布式架构里 分库分表；类似uuid
     * 条件1：IdType.ID_WORKER
     * 条件2：主键参数必须为 long
     * @TableId(value = "id", type = IdType.ID_WORKER)
     *
     *
     */
    /**
     * 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

}