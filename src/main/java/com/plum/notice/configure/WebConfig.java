package com.plum.notice.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private String resourcePath = "/upload/**";

    //private String savePath = "file:///C:/Users/dovmf/Desktop/project/side_project/src/main/resources/upload_files/";
    private String savePath = "file:///C:/Users/SeulGi/Desktop/Developer/이직준비/notice/src/main/resources/upload_files/";

    @SuppressWarnings("null")
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
