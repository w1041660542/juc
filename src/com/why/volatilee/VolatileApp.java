package com.why.volatilee;

import java.util.Date;
import java.util.Timer;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-25 09:42
 *   1、保证线程（内存）的可见性
 *   2、防止指令重排序
 *   3、实现double、long类型的原子操作
 **/
public class VolatileApp {
    int b = 2;
    volatile int a = b + 1; // 不能保证原子性




}

