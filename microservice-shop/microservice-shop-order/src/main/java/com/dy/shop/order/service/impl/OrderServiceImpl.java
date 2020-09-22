package com.dy.shop.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dy.shop.api.entity.Order;
import com.dy.shop.api.mapper.OrderMapper;
import com.dy.shop.api.service.OrderService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Long save(Order order) {
		orderMapper.insert(order);
		return order.getId();
	}

	@Override
	public Order getByNum(String num) {
		QueryWrapper<Order> queryWrapper = new QueryWrapper<Order>();
		queryWrapper.eq("num", num);
		return orderMapper.selectOne(queryWrapper);
	}

	@Override
	public void updateById(Order order) {
		orderMapper.updateById(order);
	}

}
