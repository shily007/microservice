package com.dy.listener;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.dy.mail.MailService;
import com.netflix.appinfo.InstanceInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EurekaListener {
	private final static SimpleDateFormat SF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private final static Set<String> services = new HashSet<>();

	@Autowired
	private MailService mailService;

	@EventListener
	public void listen(EurekaInstanceCanceledEvent event) throws InterruptedException {
		String serviceId = event.getServerId();
		String appName = event.getAppName();
		// 已经下线的服务，我们不需要重复发送邮件，外层拦截
		if (services.contains(serviceId + appName)) {
			log.warn("[Out] This serviceId has canceled, serviceId : {}, appName : {}", serviceId, appName);
			return;
		}

		synchronized (this) {

			// 已经下线的服务，我们不需要重复发送邮件，内层拦截
			if (services.contains(serviceId + appName)) {
				log.warn("[In] This serviceId has canceled, serviceId : {}, appName : {}", serviceId, appName);
				return;
			}

			// 首次下线，添加发送邮件标志
			services.add(serviceId + appName);

			// 生成邮件内容邮件
			StringBuilder sb = new StringBuilder();
			sb.append("Server ID=");
			sb.append(serviceId);
			sb.append(System.getProperty("line.seperator", "\n"));
			sb.append("App=");
			sb.append(appName);
			sb.append(System.getProperty("line.seperator", "\n"));
			sb.append("time=");
			sb.append(SF.format(event.getTimestamp()));
			mailService.send(sb.toString());
		}

	}

	@EventListener
	public void listen(EurekaInstanceRegisteredEvent event) {
		String serviceId = event.getInstanceInfo().getInstanceId();
		String appName = event.getInstanceInfo().getAppName();

		// 服务重启恢复后，删掉发送邮件标志
		if (event.getInstanceInfo().getStatus().equals(InstanceInfo.InstanceStatus.UP)
				&& services.contains(serviceId + appName)) {
			log.warn("register service again, services'size : {}, delete serviceKey : {}", services.size(),
					serviceId + appName);
			services.remove(serviceId + appName);
		}
	}
}
