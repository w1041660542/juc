package com.why.future;

import java.util.concurrent.*;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-12-10 14:26
 **/
public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> ret  = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                return 33;
            }
        });
        Integer integer = null;
        try {
            integer = ret.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }
}



