package com.p4_ThreadPoolExecutor;

import java.util.concurrent.*;

public class test03 {
    public static void main(String[] args) {
        ExecutorService ES = new ThreadPoolExecutor(
                3,//核心线程数
                6,//最大线程数
                60,//保持活时间
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(3),//队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());

    }
}
