package com.p01_basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class test03_implementsCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable=new MyCallable();
        FutureTask<Integer> fu=new FutureTask<>(callable);
        Thread thread=new Thread(fu,"线程1");
        thread.start();

        System.out.println(fu.get());
    }
}
