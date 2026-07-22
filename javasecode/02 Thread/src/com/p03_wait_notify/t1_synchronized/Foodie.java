package com.p03_wait_notify.t1_synchronized;

public class Foodie extends Thread{
    @Override
    public void run() {
        while(true){
            synchronized (Table.lock){
                if(Table.num==0){
                    break;
                }else{
                    if(Table.foodFlag==0){//没有食物则等待
                        try {
                            Table.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{//有食物则吃食物,并通知厨师
                        Table.foodFlag=0;
                        Table.num--;
                        Table.lock.notifyAll();
                            System.out.println("食客吃掉了第 "+(10-Table.num)+" 碗食物 ,还能吃 "+Table.num+" 碗食物");
                    }
                }
            }
        }
    }
}
