package com.zys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cy
 * @create 2021-03-10-8:51 下午
 * @Description
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.dir") + "/src/main/resources/upload/";
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //linux服务器文件目录
        //配置磁盘映射 , pathPattern  访问路径                                        磁盘映射路径，不然不能够访问
        //这是因为对服务器的保护措施导致的，服务器不能对外部暴露真实的资源路径，需要配置虚拟路径映射访问。
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + path);
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }*/
}
