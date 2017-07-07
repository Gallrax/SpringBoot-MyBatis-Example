package com.sm.async;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Gallrax on 2017/7/7.
 */
@Component
public class DoAsync {

    private static Logger logger = Logger.getLogger(DoAsync.class);

    public boolean doIndex() {
        try {
            logger.info("正在建立索引");
            //刷新索引
            logger.info("索引建立成功");
            return true;
        } catch (Exception e) {
            //当发生异常是说明建立索引失败，应上报
            logger.info("索引建立失败");
            return false;
        }
    }

    /**
     * 异步刷新索引
     * @PostConstruct 注解为启动后执行一次
     */
    @PostConstruct
    @Async
    public boolean index() {
        int i = 0;
        while (true) {
            i++;
            //当建立索引成功是结束
            if(doIndex()) return true;
            //当建立索引超过三次即为失败
            if(i > 3) {
                //提示信息或者抛异常
                logger.info("索引建立失败");
                return false;
            }
        }
    }

}
