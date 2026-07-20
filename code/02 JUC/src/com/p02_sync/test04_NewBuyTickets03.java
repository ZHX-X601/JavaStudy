package com.p02_sync;

public class test04_NewBuyTickets03 {
    public static void main(String[] args) {
        NewBuyTickets03 newBuyTickets03 =new NewBuyTickets03();
        Thread t1=new Thread(newBuyTickets03,"窗口1");
        Thread t2=new Thread(newBuyTickets03,"窗口2");
        Thread t3=new Thread(newBuyTickets03,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
