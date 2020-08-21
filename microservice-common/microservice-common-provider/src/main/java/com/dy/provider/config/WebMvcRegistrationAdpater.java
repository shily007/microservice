package com.dy.provider.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import feign.Feign;

@Configuration
@ConditionalOnClass({ Feign.class })
public class WebMvcRegistrationAdpater {

	@Bean
	public WebMvcRegistrations feignWebRegistrations() {
		return new WebMvcRegistrations() {
			@Override
			public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
				return new RequestMappingHandlerMapping() {
					@Override
					protected boolean isHandler(Class<?> beanType) {
						return super.isHandler(beanType) && !beanType.isInterface();
					}
				};
			}
		};
	}
}
