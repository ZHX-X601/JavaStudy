package com.p01_basic;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(int i=0;i<100;i++){
            sum+=i;
            //获取当前线程对象,再获取线程名称
            System.out.println(Thread.currentThread().getName() + "正在运行"+i);
            //让线程休眠10毫秒
            //Thread.sleep(10);
        }
        return sum;
    }
}
