package com.feng.springboot.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    public static boolean active = false;
    private static Contact contact = new Contact("xiaofeng", "https://github.com/xiaofeng333", "xiaofeng5172@gamil.com");

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(active)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.feng.springboot"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建API")
                .description("springboot2")
                .termsOfServiceUrl("https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/pdf/spring-boot-reference.pdf")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
