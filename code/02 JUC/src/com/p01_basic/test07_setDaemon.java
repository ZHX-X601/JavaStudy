package com.p01_basic;

public class test07_setDaemon{
    public static void main(String[] args) {
        Thread t1 = new MyTread("线程1");//10次
        Thread t2=new Thread(new MyRunnable(),"线程2");//100次

        t2.setDaemon(true);//设置线程为守护线程,其他非守护线程结束时,守护线程也会被销毁

        t1.start();
        t2.start();


    }
}

/*
D:\develop\jdk\jdk17\bin\java.exe "-javaagent:D:\develop\IntelliJ IDEA 2025.2\lib\idea_rt.jar=14471" -Dfile.encoding=UTF-8 -classpath D:\文件\markdown\JavaStudy\code\out\production\多线程 com.Test01.test07
线程2正在运行0
线程1正在运行0
线程2正在运行1
线程1正在运行1
线程2正在运行2
线程1正在运行2
线程2正在运行3
线程1正在运行3
线程2正在运行4
线程1正在运行4
线程2正在运行5
线程2正在运行6
线程1正在运行5
线程2正在运行7
线程1正在运行6
线程1正在运行7
线程2正在运行8
线程1正在运行8
线程2正在运行9
线程1正在运行9
线程2正在运行10
线程2正在运行11
线程2正在运行12
线程2正在运行13
线程2正在运行14
线程2正在运行15
线程2正在运行16
线程2正在运行17
线程2正在运行18
线程2正在运行19
线程2正在运行20
线程2正在运行21
线程2正在运行22
线程2正在运行23
线程2正在运行24
线程2正在运行25
线程2正在运行26
线程2正在运行27
线程2正在运行28
线程2正在运行29
 */