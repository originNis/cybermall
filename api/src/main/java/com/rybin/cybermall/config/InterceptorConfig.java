package com.rybin.cybermall.config;

import com.rybin.cybermall.interceptor.CheckTokenInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private CheckTokenInterceptor  checkTokenInterceptor;

    // 写好功能的拦截器还需要到此处配置给Spring管理
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)
                .addPathPatterns("/shopcart/**");
    }
}
