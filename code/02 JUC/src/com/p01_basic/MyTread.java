package com.p01_basic;

public class MyTread extends Thread {
    public MyTread(String name) {
        super(name);
    }

    public MyTread() {
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(this.getName() + "正在运行"+i);
            //Thread.yield();
        }
    }

}
