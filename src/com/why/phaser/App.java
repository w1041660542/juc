package com.why.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-27 11:12
 **/
public class App {

    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        // 1. 注册一个 party
        phaser.register();
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        for (int i = 0; i < 10; i++) {
            int ii = i;
            phaser.register();

            executorService.submit(() -> {

                // 2. 每个线程到这里进行阻塞，等待所有线程到达栅栏
                System.out.println("wait.. " + (ii+1));
                phaser.arriveAndAwaitAdvance();
                System.out.println("work.. ");
                // doWork()
            });
        }
        phaser.arriveAndAwaitAdvance();
    }
}

