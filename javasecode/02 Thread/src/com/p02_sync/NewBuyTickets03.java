package com.p02_sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewBuyTickets03 implements Runnable{
    private int num=0;

    Lock lock=new ReentrantLock();
    //操作同一资源的线程，必须使用同一把锁对象

    @Override
    public void run() {
        while(true){

            lock.lock();
            try {

                if(num==100){//售空
                    break;
                }else{
                    num++;
                    System.out.println(Thread.currentThread().getName()+" 正在卖出第 "+num+" 张票");
                }
            } finally {
                lock.unlock();//保证无论如何都能释放锁
            }

        }
    }
}
