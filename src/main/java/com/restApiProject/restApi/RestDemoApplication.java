package com.restApiProject.restApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
@EnableWebSecurity
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.restApiProject.restApi"))
				.build()
				.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData(){
		return new ApiInfo(
 				"Contact Information API Application",
				"REST API that can be used to manage a list of contacts",
				"1.0",
				"Contact Service Terms",
				new Contact("Yuvraj Bhati", "https://www.linkedin.com/in/yuvraj-bhati-64851b1a6/",
						"yuvrajbhati2507@gmail.com"),
				"Yuvraj Bhati Contact REST API Project",
				"https://github.com/i-am-yuv",
				Collections.emptyList()
		);
	}

}

