package com.p03_wait_notify.t2_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{
    ArrayBlockingQueue<String> queue=null;

    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int num=10;
        while(true){
            if(num==0){
                break;
            }else{
                try {
                    String food = queue.take();
                    num--;
                    System.out.println("食客吃掉了 "+food+" ,还能吃 "+num+" 碗食物");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
