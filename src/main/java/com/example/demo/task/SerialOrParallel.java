/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SerialOrParallel
 * Author:   ZhuBin
 * Date:     2019/7/8 10:28
 * Description: 多个定时任务测试
 * History:
 * <author>      <time>               <version>          <desc>
 * SerialOrParallel       2019/7/8 10:28          1.0.0              多个定时任务测试
 */
package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * 〈一句话功能简述〉<br> 
 * 〈多个定时任务测试〉
 *
 * @author ZhuBin
 * @create 2019/7/8
 * @since 1.0.0
 */
//@Component
public class SerialOrParallel {

    @Scheduled(cron = "0/1 * * * * ?")
    public void sc1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" task1");
        while (true) {
            Thread.sleep(5000);
        }
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void sc2() {
        System.out.println(Thread.currentThread().getName()+" task2");
    }
/**
 * 输出
 scheduling-1 task2
 scheduling-1 task1
 * 多个定时任务串行
 */
}