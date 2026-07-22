package com.p01_basic;

public class test01_extendsThread {
    public static void main(String[] args) {

        //创建线程对象,并设置线程名称
        MyTread myTread1 = new MyTread("线程1");
        MyTread myTread2 = new MyTread();


        //设置线程名称
        myTread2.setName("线程2");

        myTread1.start();
        myTread2.start();

    }
}
