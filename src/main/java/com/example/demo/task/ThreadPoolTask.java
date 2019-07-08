/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ThreadPoolTask
 * Author:   ZhuBin
 * Date:     2019/7/8 10:35
 * Description: 使用线程池执行多个并行定时任务
 * History:
 * <author>      <time>               <version>          <desc>
 * ThreadPoolTask       2019/7/8 10:35          1.0.0              使用线程池执行多个并行定时任务
 */
package com.example.demo.task;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用线程池执行多个并行定时任务〉
 *
 * @author ZhuBin
 * @create 2019/7/8
 * @since 1.0.0
 */
@Component
public class ThreadPoolTask {
    @Bean(name = "taskThreadPool")
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("thread_pool ");
        executor.setMaxPoolSize(10);
        executor.setCorePoolSize(3);
        executor.setQueueCapacity(0);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

    @Scheduled(cron = "0/1 * * * * ?")
    @Async
    public void sc1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " task");
        while (true) {
            Thread.sleep(1000 * 5);
        }
    }
}