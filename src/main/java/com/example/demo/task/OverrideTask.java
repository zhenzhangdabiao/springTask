/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OverrideTask
 * Author:   ZhuBin
 * Date:     2019/7/8 10:48
 * Description:
 * History:
 * <author>      <time>               <version>          <desc>
 * OverrideTask       2019/7/8 10:48          1.0.0
 */
package com.example.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ZhuBin
 * @create 2019/7/8
 * @since 1.0.0
 */
@Component
@Slf4j
public class OverrideTask implements SchedulingConfigurer{
    @Override
    public void configureTasks(@Autowired ScheduledTaskRegistrar taskRegistrar) {
        //从配置文件中读取定时任务发布的间隔
        Integer crlTimeDiff = getCrlTimeDiff();
        if (crlTimeDiff == null || crlTimeDiff <= 0) {
            log.info("定时器的时间间隔未配置或配置有误：" + crlTimeDiff);
            return;
        }
        // 动态拼接cron表达式
        String cron = "0 0/" + crlTimeDiff + " * * * ?";
        taskRegistrar.addCronTask(() -> {
            LocalDateTime beginTime = LocalDateTime.now();
            log.info("CRL发布定时任务执行时间: " + System.currentTimeMillis());
            try {
                //todo
            } catch (Exception ex) {
                log.info("CRL发布定时任务异常：", ex);
            }
            log.info("CRL发布定时任务执行完毕");
        }, cron);
    }

    Integer getCrlTimeDiff(){
        //todo 获取定时时间间隔
        return null;
    }
}