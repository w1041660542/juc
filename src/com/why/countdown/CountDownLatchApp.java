package com.why.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-27 08:58
 *
 * 实现一个容器，提供两个方法，add，size 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束? 使用CountDownLatch 代替wait notify 好处。
 **/
public class CountDownLatchApp {




        public static void main(String[] args) {
            List<String> container = new ArrayList<>();

            CountDownLatch countDownLatch = new CountDownLatch(5);


            Thread size = new Thread(() ->{
                try {
                    countDownLatch.await();
                    System.out.println("检测到容器已添加五个");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            size.start();

            Thread add = new Thread(() ->{

                try {

                    for (int i = 0; i < 10; i++) {
                        container.add(i+"");
                        System.out.println("添加了" + (i+1) + "个");
                        countDownLatch.countDown();
                        Thread.sleep(2000);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            add.start();





        }


}

