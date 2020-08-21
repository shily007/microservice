package com.dy.api.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @author dy
 *
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
	
	public interface SimpleView {};
	public interface DetailView extends SimpleView {};

	private static final long serialVersionUID = 1L;

	@JsonView(SimpleView.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

	@JsonView(SimpleView.class)
	@ApiModelProperty(value = "创建时间")
    @TableField("ctTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ctTime = LocalDateTime.now();

}
