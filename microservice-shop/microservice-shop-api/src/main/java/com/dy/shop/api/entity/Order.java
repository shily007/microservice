package com.dy.shop.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@TableName("shop_order")
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String num;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品id
     */
    private Long gid;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 商品单价（分）
     */
    private Integer price;

    /**
     * 小计（分为）
     */
    private Integer subtotal;
    
	/**
	 * 创建时间
	 */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time = LocalDateTime.now();

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货地址
     */
    private String addr;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 状态
     */
    private Integer state;


}
