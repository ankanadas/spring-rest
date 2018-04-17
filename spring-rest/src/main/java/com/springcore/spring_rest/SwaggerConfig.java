package com.springcore.spring_rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//	@Bean
//	public Docket api(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.pathMapping("/api/*")
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build()
//				.useDefaultResponseMessages(false)
//				.apiInfo(apiInfo());
//	}
//	private ApiInfo apiInfo(){
//		Contact contact = new Contact("Ankana","https://www.linkedin.com/in/ankana-d-a54b6414b/","www.linkedin.com");
//		ApiInfo info = new ApiInfo("Spring-Rest API", "A Simple Rest API", "1.0.0", "TnC", contact, "MIT License", "https://opensource.org/licenses/MIT");
//	return info;	
	//}
}