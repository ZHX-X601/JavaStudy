package com.p02_sync;

public class NewBuyTickets01 implements Runnable{
    private int num=0;
    //不使用静态是因为所有线程共享一个NewBuyTickets01对象，操作的自然就是一份num

    @Override
    public void run() {
        while(true){
            //括号中的对象是锁对象，为防止冲突，凡是操作同一份资源的线程，都必须使用同一把锁对象
            //这里使用NewBuyTickets01.class作为锁对象
            // 因为所有线程共享一个NewBuyTickets01对象，所以这里也可以使用this作为锁对象
            synchronized (NewBuyTickets01.class){
                if(num==100){//售空
                    break;
                }else{
                    num++;
                    System.out.println(Thread.currentThread().getName()+" 正在卖出第 "+num+" 张票");
                }
            }
        }
    }
}
