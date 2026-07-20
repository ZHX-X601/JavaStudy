package com.p03_wait_notify.t1_synchronized;

public class Table {

    // 0：没有食物 1：有食物
    static public int foodFlag = 0;

    //食客还能吃多少
    static public int num=10;

    static public Object lock = new Object();

}
