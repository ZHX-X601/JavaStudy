package com.p03_wait_notify.t1_synchronized;

public class Cook extends Thread{
    @Override
    public void run() {
        while(true){
            synchronized (Table.lock){
                if(Table.num==0){
                    break;
                }else{
                    if(Table.foodFlag==1){//有食物则等待
                        try {
                            Table.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{//没有食物则生产食物,并通知食客
                        Table.foodFlag=1;
                        Table.lock.notifyAll();
                        System.out.println("厨师生产了食物");
                    }
                }
            }
        }
    }
}
