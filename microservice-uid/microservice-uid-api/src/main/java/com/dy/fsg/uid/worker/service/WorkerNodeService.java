package com.dy.fsg.uid.worker.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.api.utils.JsonResult;
import com.dy.fsg.uid.worker.entity.WorkerNodeEntity;
import com.dy.fsg.uid.worker.fallback.WorkerNodeServiceFallback;

/**
 * 
 * 
 * @author dy
 * 2020年8月20日
 */
@FeignClient(value = "MICROSERVICE-UID-SERVER",fallbackFactory = WorkerNodeServiceFallback.class)
@RequestMapping("workerNode")
@ResponseBody
public interface WorkerNodeService {
	
	@PostMapping
	JsonResult<WorkerNodeEntity> insert(@RequestBody WorkerNodeEntity entity);

}
