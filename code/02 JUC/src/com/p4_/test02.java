package com.p4_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test02 {
    /*
        public static ExecutorService newCachedThreadPool()             创建一个没有上限的线程池
        public static ExecutorService newFixedThreadPool (int nThreads) 创建有上限的线程池
    */
    public static void main(String[] args) {
        ExecutorService ES = Executors.newFixedThreadPool(3);
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());
        ES.submit(new MyRunnable());

    }
}
