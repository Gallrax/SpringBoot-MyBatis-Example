package com.sm;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/7/5.
 */
@SpringBootApplication
@MapperScan("com.sm.dao")
public class Application {

    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("----- 启动中 -----");
        SpringApplication.run(Application.class, args);
        logger.info("----- 启动成功 -----");
    }
}