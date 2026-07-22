package com.p01_basic;

public class test06_yield {
    public static void main(String[] args) {
        Thread t1 = new MyTread("线程1");
        Thread t2 = new MyTread("线程2");
        //在MyTread类中,调用yield方法,让当前线程让出CPU
        //可以让两个线程交替运行，但不绝对保证

        t1.start();
        t2.start();

    }
}

/*

package com.TestOne;

public class MyTread extends Thread {
    public MyTread(String name) {
        super(name);
    }

    public MyTread() {
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(this.getName() + "正在运行"+i);
            Thread.yield();//调用yield方法,让当前线程让出CPU资源
        }
    }

}
 */