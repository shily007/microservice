package com.dy.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dy
 * @since 2020-09-22
 */
@TableName("s_student")
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 状态 0：正常，1：冻结，2：注销
     */
    private Integer state;

    /**
     * 身份证号码
     */
    private String idno;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 班级id
     */
    @TableField("clazzId")
    private Long clazzId;

    /**
     * 年级id
     */
    @TableField("gradeId")
    private Long gradeId;

    /**
     * 专业id
     */
    @TableField("majorId")
    private Long majorId;

    /**
     * 生源地id
     */
    @TableField("sourceId")
    private Long sourceId;

    /**
     * 创建时间
     */
    private LocalDateTime time;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 最后修改时间
     */
    private LocalDateTime uptime;

    /**
     * 最后修改人
     */
    private String updater;


}
