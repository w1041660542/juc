package com.why.cyclicbarrier;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-27 10:57
 **/

import java.util.concurrent.CyclicBarrier;

class MyThread extends Thread {
    private CyclicBarrier cb;
    public MyThread(String name, CyclicBarrier cb) {
        super(name);
        this.cb = cb;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " 等待到达");
        try {
            cb.await();
            System.out.println(Thread.currentThread().getName() + " 继续");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
