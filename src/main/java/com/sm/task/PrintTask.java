package com.sm.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gallrax on 2017/7/7.
 */

@Component
public class PrintTask {

    private static Logger logger = Logger.getLogger(PrintTask.class);

    @Scheduled(fixedRate = 60000)
    public void pringTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("当前时间为："+ sdf.format(new Date()));
    }
}
