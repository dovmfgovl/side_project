package com.plum.notice.configure;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    private String resourcePath = "/upload/**";

    private String savePath = "C:\\Users\\dovmf\\Desktop\\project\\side_project\\src\\main\\resources\\upload_files";
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath).addResourceLocations(savePath);
    }
}
