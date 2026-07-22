package com.p01_basic;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            //获取当前线程对象,再获取线程名称
            System.out.println(Thread.currentThread().getName() + "正在运行"+i);
        }
    }
}
