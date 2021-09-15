package com.zys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author cy
 * @create 2021-03-15-1:41 下午
 * @Description
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket docket0() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("关于用户接口")
                .enable(true) //是否启动Swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zys.controller"))
                .paths(PathSelectors.ant("/userInfo/**"))
                .build()
                ;
    }

    //配置docket以配置Swagger具体参数
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("轮播图")
                .enable(true) //是否启动Swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zys.controller"))
                .paths(PathSelectors.ant("/swiperItems/**"))
                .build()
                ;
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("关于课程接口")
                .enable(true) //是否启动Swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zys.controller"))
                .paths(PathSelectors.ant("/studyCourse/**"))
                .build()
                ;
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("关于教师接口")
                .enable(true) //是否启动Swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zys.controller"))
                .paths(PathSelectors.ant("/teacher/**"))
                .build()
                ;
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("赵元硕", "这是我的个人网页", "这是我的邮箱");
        // public ApiInfo(String title, String description, String version, String termsOfServiceUrl, Contact contact, String ", String licenseUrl, Collection<VendorExtension> vendorExtensions) {
        return new ApiInfo("在线学习小程序API文档", // 标题
                "所有接口文档都存在于此", // 描述
                "v1.0", // 版本
                "", // 组织链接
                contact, // 联系人信息
                "", // 许可
                "", // 许可连接
                new ArrayList<>()); // 扩展
    }
}
