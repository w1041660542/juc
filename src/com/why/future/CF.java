package com.why.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-12-10 15:07
 **/
public class CF {

    public static void main(String[] args) throws InterruptedException {
        String result = CompletableFuture.supplyAsync(() -> "hello ").thenApplyAsync(s -> s+"world").join();
        System.out.println(result);


        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MICROSECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务结束！");
        });

        completableFuture.whenComplete((t,action) -> System.out.println("执行完成"));

        System.out.println("主线程执行完成");

        TimeUnit.MICROSECONDS.sleep(5000);

    }
}

