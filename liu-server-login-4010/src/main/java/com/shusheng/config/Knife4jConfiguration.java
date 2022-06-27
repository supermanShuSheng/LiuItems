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
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        // 描述
                        .description("测试接口文档聚合")
                        .termsOfServiceUrl("http://127.0.0.1:4010/doc.html")
                        .contact(new Contact("刘闯","","344439833@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称 默认为default
//                .groupName("用户操作接口文档")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.shusheng.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
