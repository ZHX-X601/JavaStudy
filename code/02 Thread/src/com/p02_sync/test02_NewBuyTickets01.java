package com.p02_sync;

public class test02_NewBuyTickets01 {
    public static void main(String[] args) {
        NewBuyTickets01 newBuyTickets01 =new NewBuyTickets01();
        Thread t1=new Thread(newBuyTickets01,"窗口1");
        Thread t2=new Thread(newBuyTickets01,"窗口2");
        Thread t3=new Thread(newBuyTickets01,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
