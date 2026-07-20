package com.p01_basic;

public class test02_implementsRunnable {
    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable());
        Thread t2=new Thread(new MyRunnable(),"线程2");

        t1.setName("线程1");

        t1.start();
        t2.start();
    }
}
