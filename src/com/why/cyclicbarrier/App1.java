package com.why.cyclicbarrier;

import java.util.concurrent.*;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-27 10:31
 **/
public class App1 {

    public static void main(String[] args) {

        // 1. 构造函数中指定了 10 个 parties
        CyclicBarrier barrier = new CyclicBarrier(10,new Thread(() -> {
            System.out.println("barrier action");
        }));
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            int ii = i;
            executorService.submit(() -> {
                try {
                    // 2. 每个线程"报告"自己到了，
                    //    当第10个线程到的时候，也就是所有的线程都到齐了，一起通过
                    System.out.println("等待 ：" + (ii+1));
                    barrier.await();
                    System.out.println("dowork..");
                    // doWork()

                } catch (InterruptedException | BrokenBarrierException ex) {
                    ex.printStackTrace();
                }
            });
        }


    }
}

