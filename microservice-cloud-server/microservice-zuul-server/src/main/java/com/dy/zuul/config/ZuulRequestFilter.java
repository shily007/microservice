package com.dy.zuul.config;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 网关限流
 */
@Component
public class ZuulRequestFilter extends ZuulFilter {

	@Autowired
	private Logger logger;
	@Autowired
	private ZuulProperties zuulProperties;
	private RateLimiter RATE_LIMITER;

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return -4;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		logger.info("获取令牌");
		if (RATE_LIMITER == null) {
			synchronized (this) {
				if (RATE_LIMITER == null) {
					RATE_LIMITER = RateLimiter.create(zuulProperties.getPermitsPerSecond());
				}
			}
		}
		boolean tryAcquire = RATE_LIMITER.tryAcquire();
		// 如果获取不到就直接停止
		if (!tryAcquire) {
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
		}
		return null;
	}
}