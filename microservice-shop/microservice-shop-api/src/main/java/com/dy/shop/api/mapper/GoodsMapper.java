package com.dy.shop.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dy.shop.api.entity.Goods;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}
