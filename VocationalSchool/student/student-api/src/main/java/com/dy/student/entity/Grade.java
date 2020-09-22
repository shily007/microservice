package com.dy.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
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
@TableName("s_grade")
@Data
@EqualsAndHashCode(callSuper = false)
public class Grade implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 年级名称
     */
    private Integer name;

    /**
     * 年级简称
     */
    private String abbreviation;

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
