package com.p01_basic;

public class test04_setPriority {
    public static void main(String[] args) {
        Thread t1 = new MyTread("线程1");
        Thread t2 = new MyTread("线程2");

        System.out.println("线程1默认的优先级为:"+t1.getPriority());//默认5级
        System.out.println("线程2默认的优先级为:"+t2.getPriority());//默认5级

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}
