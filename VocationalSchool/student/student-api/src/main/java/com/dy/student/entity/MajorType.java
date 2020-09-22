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
@TableName("s_major_type")
@Data
@EqualsAndHashCode(callSuper = false)
public class MajorType implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 专业id
     */
    @TableField("majorId")
    private Long majorId;

    /**
     * 专业类型
     */
    private String type;

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
