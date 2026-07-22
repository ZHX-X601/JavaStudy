package com.p03_wait_notify.t2_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class test01 {
    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Cook cook = new Cook(queue);
        Foodie foodie = new Foodie(queue);
        cook.start();
        foodie.start();

    }
}
