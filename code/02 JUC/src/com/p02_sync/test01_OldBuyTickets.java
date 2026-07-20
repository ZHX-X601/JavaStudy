package com.p02_sync;

public class test01_OldBuyTickets{
    public static void main(String[] args) {
        Thread t1=new OldBuyTickets("窗口1");
        Thread t2=new OldBuyTickets("窗口2");
        Thread t3=new OldBuyTickets("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
/*
出现将同一张票卖多次，以及售空后继续卖票的情况
原因是：OldBuyTickets，num变量是共享的，多个线程同时访问num变量，售票的过程CUP执行权可能切换，导致num变量的值不一致
D:\develop\jdk\jdk17\bin\java.exe "-javaagent:D:\develop\IntelliJ IDEA 2025.2\lib\idea_rt.jar=8999" -Dfile.encoding=UTF-8 -classpath D:\文件\markdown\JavaStudy\code\out\production\多线程 com.Test02.test01_OldBuyTickets
窗口1 正在卖出第 3 张票
窗口3 正在卖出第 3 张票
窗口2 正在卖出第 3 张票
窗口3 正在卖出第 5 张票
窗口1 正在卖出第 4 张票
窗口3 正在卖出第 7 张票
窗口2 正在卖出第 6 张票
窗口3 正在卖出第 9 张票
窗口1 正在卖出第 8 张票
窗口3 正在卖出第 11 张票
 */
