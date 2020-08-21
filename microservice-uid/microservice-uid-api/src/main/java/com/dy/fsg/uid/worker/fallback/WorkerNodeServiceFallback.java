package com.dy.fsg.uid.worker.fallback;


import org.springframework.stereotype.Component;

import com.dy.api.utils.JsonResult;
import com.dy.fsg.uid.worker.entity.WorkerNodeEntity;
import com.dy.fsg.uid.worker.service.WorkerNodeService;

import feign.hystrix.FallbackFactory;

@Component
public class WorkerNodeServiceFallback implements FallbackFactory<WorkerNodeService> {

	@Override
	public WorkerNodeService create(Throwable cause) {
		return new WorkerNodeService() {

			@Override
			public JsonResult<WorkerNodeEntity> insert(WorkerNodeEntity entity) {
				entity.setId(-1);
				return new JsonResult<>(entity);
			}
		};
	}

}
