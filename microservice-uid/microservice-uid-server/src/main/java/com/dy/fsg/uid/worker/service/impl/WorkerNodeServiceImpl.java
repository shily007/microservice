package com.dy.fsg.uid.worker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.api.utils.JsonResult;
import com.dy.fsg.uid.worker.dao.WorkerNodeMapper;
import com.dy.fsg.uid.worker.entity.WorkerNodeEntity;
import com.dy.fsg.uid.worker.service.WorkerNodeService;

/**
 * 
 * 
 * @author dy
 * 2020年8月20日
 */
@Service
public class WorkerNodeServiceImpl implements WorkerNodeService {

	@Autowired
	private WorkerNodeMapper workerNodeMapper;
	
	@Override
	public JsonResult<WorkerNodeEntity> insert(WorkerNodeEntity entity) {
		workerNodeMapper.insert(entity);
		return new JsonResult<>(entity);
	}

}
