package com.p01_basic;

public class test05_join {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyTread("线程1");

        t1.start();
        t1.join();//将线程1插入主线程前,等待线程1执行完毕

        for(int i=0;i<100;i++){
            System.out.println("线程"+Thread.currentThread().getName()+i);
        }


    }
}
