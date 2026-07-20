package com.p4_ThreadPoolExecutor;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("Thread"+Thread.currentThread().getName()+" hello world");
        }
    }
}
