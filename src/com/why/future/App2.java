package com.why.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-12-10 14:29
 **/
public class App2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = () -> {
            System.out.println("执行call前");
            int ramdomNum = new Random().nextInt(1000);
            return ramdomNum;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        System.out.println("thread 启动");
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}

