package com.dy.shop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.shop.api.JsonResult;
import com.dy.shop.api.entity.Goods;
import com.dy.shop.api.mapper.GoodsMapper;
import com.dy.shop.api.service.GoodsService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public JsonResult<Goods> getById(Long gid) {
		Goods goods = goodsMapper.selectById(gid);
		return new JsonResult<Goods>(goods);
	}

	@Override
	public JsonResult<String> reduce(Long gid, Integer amount) {
		Goods goods = goodsMapper.selectById(gid);
		if (goods != null && goods.getAmount() >= amount) {
			goods.setAmount(goods.getAmount() - amount);
			goodsMapper.updateById(goods);
			return new JsonResult<String>(0);
		}
		return new JsonResult<>("操作失败");
	}

	@Override
	public void increase(Long gid, Integer quantity) {
		Goods goods = goodsMapper.selectById(gid);
		if (goods != null) {
			goods.setAmount(goods.getAmount() + quantity);
			goodsMapper.updateById(goods);
		}
	}

}
