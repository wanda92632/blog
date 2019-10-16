package com.zhifei.blog.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author ZhiFei
 */
@Configuration
public class MyThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 0;
    private static final int MAXIMUM_POOL_SIZE =Integer.MAX_VALUE;
    private static final long KEEP_ALIVE_TIME =60;
    private static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new SynchronousQueue<>();

    @Bean
    public ThreadPoolExecutor getThreadPoolExecutor(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, UNIT, WORK_QUEUE,Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }
}
