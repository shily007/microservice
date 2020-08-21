package com.dy.api.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dy.api.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dy
 * @since 2019-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_adminLog")
public class AdminLog extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 操作内容
     */
    private String content;

    /**
     * 操作人
     */
//    @NotBlank
//    @Size(min = 5,max = 18)
    private String creater;

    /**
     * 备注
     */
    private String remark;

    /**
     * 内网IP
     */
//    @Size(min = 15,max = 15)
    @TableField("innerIp")
    private String innerIp;

    /**
     * 外网id
     */
    @TableField("outerIp")
    private String outerIp;


}
