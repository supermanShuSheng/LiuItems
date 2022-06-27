package com.shusheng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * 开启Knife4j
 * @author 刘闯
 * @date 2021/3/17.
 */

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean
    public Docket defaultApi3() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("一体化线损接口文档")
                        .description("我是多线程")
                        .termsOfServiceUrl("http://localhost:8082/doc.html")
                        .contact(new Contact("刘闯","","344439833@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("demo文档")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.shusheng.controller.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("一体化线损接口文档1111")
                        .description("我是多线程11111")
                        .termsOfServiceUrl("http://localhost:8082/doc.html")
                        .contact(new Contact("刘闯","","344439833@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("mynamedemo1文档")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.shusheng.controller.mynamedemo1"))
                .paths(PathSelectors.any())
                .build();
    }
}
