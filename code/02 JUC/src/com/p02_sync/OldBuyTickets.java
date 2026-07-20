package com.p02_sync;

public class OldBuyTickets extends Thread{
    //已经售出的票数
    static private int num = 0;


    public OldBuyTickets() {
    }

    public OldBuyTickets(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if(num==100){//售空
                break;
            }else{
                num++;
                System.out.println(this.getName()+" 正在卖出第 "+num+" 张票");
            }
        }
    }
}
