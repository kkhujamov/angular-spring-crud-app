package com.restgo.cruddemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 11:53 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {

        List<ResponseMessage> list = new java.util.ArrayList<>();
        list.add(new ResponseMessageBuilder().code(500).message("500 message").build());
        list.add(new ResponseMessageBuilder().code(401).message("Unauthorized").build());
        list.add(new ResponseMessageBuilder().code(406).message("Not Acceptable").build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.restgo.cruddemo"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
//                .securitySchemes(Collections.singletonList(securitySchema()))
//                .securityContexts(Collections.singletonList(securityContext()))
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, list)
                .globalResponseMessage(RequestMethod.POST, list);


    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "CRUD App API",
                "RESTful API of Simple CRUD App",
                "Version 1.0",
                "urn:tos",
                new Contact("Khumoyun Khujamov", "http://therealstart.com", "xojamov07@gmail.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList());
    }
}
