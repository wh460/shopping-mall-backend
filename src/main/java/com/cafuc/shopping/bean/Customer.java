package com.cafuc.shopping.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wh460
 * @since 2026-07-02
 */
@Getter
@Setter
@TableName("customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 当前意向id
     */
    @TableField("customer_relationship_id")
    private Integer customerRelationshipId;

    /**
     * 创建时间
     */
    @TableField("create_date_time")
    private LocalDateTime createDateTime;

    /**
     * 最后更新时间
     */
    @TableField("update_date_time")
    private LocalDateTime updateDateTime;

    /**
     * 是否被删除（禁用）
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 身份证号
     */
    @TableField("idcard")
    private String idcard;

    /**
     * 出生年份
     */
    @TableField("birth_year")
    private Integer birthYear;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 微信
     */
    @TableField("wechat")
    private String wechat;

    /**
     * qq号
     */
    @TableField("qq")
    private String qq;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 所在区域
     */
    @TableField("area")
    private String area;

    /**
     * 离校时间
     */
    @TableField("leave_school_date")
    private LocalDate leaveSchoolDate;

    /**
     * 毕业时间
     */
    @TableField("graduation_date")
    private LocalDate graduationDate;

    /**
     * 博学谷学员ID，可能未关联到，不存在
     */
    @TableField("bxg_student_id")
    private String bxgStudentId;

    /**
     * 创建人ID
     */
    @TableField("creator")
    private Integer creator;

    /**
     * 数据来源
     */
    @TableField("origin_type")
    private String originType;

    /**
     * 来源渠道
     */
    @TableField("origin_channel")
    private String originChannel;

    @TableField("tenant")
    private Integer tenant;

    /**
     * 中台id
     */
    @TableField("md_id")
    private Integer mdId;
}
