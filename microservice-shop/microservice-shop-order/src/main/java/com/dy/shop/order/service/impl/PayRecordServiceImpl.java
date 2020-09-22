package com.dy.shop.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.shop.api.entity.PayRecord;
import com.dy.shop.api.mapper.PayRecordMapper;
import com.dy.shop.api.service.PayRecordService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dy
 * @since 2020-09-10
 */
@Service
public class PayRecordServiceImpl implements PayRecordService {

	@Autowired
	private PayRecordMapper payRecordMapper;
	
	@Override
	public void save(PayRecord payRecord) {
		payRecordMapper.insert(payRecord);
	}

}
