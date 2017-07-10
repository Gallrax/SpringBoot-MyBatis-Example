package com.sm;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gallrax on 2017/7/5.
 */
@SpringBootApplication
@MapperScan("com.sm.dao")
@EnableScheduling//开启定时
public class Application {

    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("----- 启动中 -----");
        SpringApplication.run(Application.class, args);
        logger.info("----- 启动成功 -----");
    }

    //配置文件两种方式，一种内部类(内部类需为静态内部类，配置文件理应优先加载)，另外一种单独写一个公开类
    @Configuration
    static class LoginIntercetor extends WebMvcConfigurerAdapter {
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new HandlerInterceptorAdapter() {
                @Override
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

                    logger.info("----- 此次访问的URI："+ request.getRequestURI() +" -----");
                    logger.info("----- 正在验证登录状态");
                    String username = (String) request.getSession().getAttribute("username");
                    if(username == null || username.isEmpty()){
                        logger.info("----- 用户未登录 -----");
                        response.sendRedirect("login");
                        return false;
                    }
                    logger.info("----- 用户已登录 -----");
                    return true;
                }
            }).addPathPatterns("/**").excludePathPatterns("/login*");//不会拦截位于static的文件
        }
    }
}