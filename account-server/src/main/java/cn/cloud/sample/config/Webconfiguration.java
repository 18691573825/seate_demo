//package cn.cloud.sample.config;
//
//import cn.cloud.sample.config.interceptor.SeataHandlerInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author LLT
// * @Description:
// * @date: 2020/6/9
// */
//@Configuration
//public class Webconfiguration implements WebMvcConfigurer{
//    public Webconfiguration() {
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册HandlerInterceptor，拦截所有请求
//        registry.addInterceptor(new SeataHandlerInterceptor()).addPathPatterns("/**");
//    }
//
//}
