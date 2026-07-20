package com.p4_ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test01 {
    /*
        public static ExecutorService newCachedThreadPool()             创建一个没有上限的线程池
        public static ExecutorService newFixedThreadPool (int nThreads) 创建有上限的线程池
    */
    public static void main(String[] args) {
        ExecutorService ES = Executors.newCachedThreadPool();
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        //关闭线程池
        //ES.shutdown();
    }
}
