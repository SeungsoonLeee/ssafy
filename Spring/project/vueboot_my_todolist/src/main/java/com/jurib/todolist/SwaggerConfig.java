package com.jurib.todolist;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jurib.todolist.controller"))
                .build();
				//.paths(PathSelectors.any()).build();
				//.select().paths(postPaths()).build();
	}

	/*
	 * private Predicate<String> postPaths() { return or(regex("/api/posts.*"),
	 * regex("/api.*")); }
	 */

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TodoList API")
				.description("TodoList API Reference for Developers")
				.version("1.0").build();
	}

}