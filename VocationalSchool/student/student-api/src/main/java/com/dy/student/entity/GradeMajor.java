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
@TableName("s_grade_major")
@Data
@EqualsAndHashCode(callSuper = false)
public class GradeMajor implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
     * 创建时间
     */
    private LocalDateTime time;

    /**
     * 创建人
     */
    private String creater;


}
