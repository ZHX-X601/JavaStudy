package com.p02_sync;

public class NewBuyTickets02 implements Runnable{
    private int num=0;

    @Override
    public void run() {
        while(true){

            if (BuyTicket()) break;

        }
    }

    //同步方法，非静态将this作为锁对象
    //如果静态，将类作为锁对象
    private synchronized boolean BuyTicket() {
        if(num==100){//售空
            return true;
        }else{
            num++;
            System.out.println(Thread.currentThread().getName()+" 正在卖出第 "+num+" 张票");
        }
        return false;
    }
}
