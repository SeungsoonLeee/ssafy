package com.ssafy.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// @Configuration : bean configuration 을 설정하기 위한 annotation -> mvc-config.xml을 대신함 
// @ComponentScan("com.ssafy.pms") : <context:component-scan base-package="com.ssafy.pms"/>
// @EnableWebMvc : <mvc:annotation-driven /> 
@Configuration
@ComponentScan("com.ssafy.pms")
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter {
	// ViewResolver 설정
	@Bean // bean으로 등록해주는 annotation
	public ViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver("/", ".jsp");
		return irvr;
	}

	// Servlet 경로와 jsp 이외의 다른 자원 요청에 대한 처리 설정
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/**").addResourceLocations("/resources/");

		// 스웨거 설정
		reg.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		reg.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
