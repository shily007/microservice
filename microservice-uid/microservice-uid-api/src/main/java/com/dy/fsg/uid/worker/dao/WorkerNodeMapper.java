/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserve.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dy.fsg.uid.worker.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dy.fsg.uid.worker.entity.WorkerNodeEntity;

/**
 * DAO for M_WORKER_NODE
 *
 * @author yutianbao
 */
@Mapper
public interface WorkerNodeMapper extends BaseMapper<WorkerNodeEntity> {

    /**
     * Get {@link WorkerNodeEntity} by node host
     * 
     * @param host
     * @param port
     * @return
     */
//    WorkerNodeEntity getWorkerNodeByHostPort(@Param("host") String host, @Param("port") String port);

    /**
     * Add {@link WorkerNodeEntity}
     * 
     * @param workerNodeEntity
     */
//    void addWorkerNode(WorkerNodeEntity workerNodeEntity);
	
//	@Insert("INSERT INTO WORKER_NODE(ID,HOST_NAME,PORT,TYPE,LAUNCH_DATE,MODIFIED,CREATED) VALUES(#{id},#{hostName},#{port},#{type},#{launchDate},#{modified},#{created})")
//	@Options(useGeneratedKeys = true, keyProperty = "ID", keyColumn = "ID")
//	@Override
//	int insert(WorkerNodeEntity entity);

}
