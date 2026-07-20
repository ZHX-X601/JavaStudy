package com.p03_wait_notify.t1_synchronized;

public class test01 {
    public static void main(String[] args) {
        Cook cook = new Cook();
        Foodie foodie = new Foodie();
        cook.start();
        foodie.start();

    }
}
