package com.dy.api.service;

import com.dy.api.base.BaseService;
import com.dy.api.entity.AdminLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "CLOUD-SYS-PROVIDER", fallbackFactory = AdminLogFallbackFactory.class)
@RequestMapping("adminLog")
public interface AdminLogService extends BaseService<AdminLog> {

}
