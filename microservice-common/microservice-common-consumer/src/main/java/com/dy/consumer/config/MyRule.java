package com.dy.consumer.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

@Configuration
public class MyRule extends AbstractLoadBalancerRule implements Cloneable, Comparable<MyRule>, InvocationHandler {

	@Override
	public Server choose(Object key) {
		ILoadBalancer lb = getLoadBalancer();
		List<Server> servers = lb.getReachableServers();
		if (servers.size() > 0) {
			return servers.get(0);
		}
		return null;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {

	}

	@Override
	public int compareTo(MyRule o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		return null;
	}

}
