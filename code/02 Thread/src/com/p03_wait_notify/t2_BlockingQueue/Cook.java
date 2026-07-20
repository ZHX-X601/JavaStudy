package com.p03_wait_notify.t2_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{



    ArrayBlockingQueue<String> queue=null;
    public Cook(ArrayBlockingQueue<String> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        int idx=0;
        int num=10;
        while(true){
            if(num==0){
                break;
            }else{
                try {
                    ++idx;
                    num--;
                    queue.put("食物"+idx);
                    System.out.println("厨师生产了"+" 食物"+idx);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
