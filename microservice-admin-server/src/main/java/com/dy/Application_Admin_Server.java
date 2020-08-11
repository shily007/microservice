package com.dy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.dy.utils.jasypt.JasyptConstants;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
@EnableAutoConfiguration
public class Application_Admin_Server {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
		SpringApplication.run(Application_Admin_Server.class, args);
	}

//	@Configuration
//	public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
//		private final String adminContextPath;
//
//		public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
//			this.adminContextPath = adminServerProperties.getContextPath();
//		}
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//			successHandler.setTargetUrlParameter("redirectTo");
//			successHandler.setDefaultTargetUrl(adminContextPath + "/");
//
//			http.authorizeRequests().antMatchers(adminContextPath + "/assets/**").permitAll()
//					.antMatchers(adminContextPath + "/login").permitAll().anyRequest().authenticated().and().formLogin()
//					.loginPage(adminContextPath + "/login").successHandler(successHandler).and().logout()
//					.logoutUrl(adminContextPath + "/logout").and().httpBasic().and().csrf()
//					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//					.ignoringAntMatchers(adminContextPath + "/instances", adminContextPath + "/instances/**",
//							 adminContextPath + "/actuator/**");
//		}
//	}

}
