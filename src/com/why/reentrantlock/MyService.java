package com.why.reentrantlock;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-14 15:48
 **/
public class MyService {

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void awit(){
            try {
                lock.lock();
                System.out.println("锁住了" + System.currentTimeMillis());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        public void signal(){

           try {
               lock.lock();
               System.out.println("通知继续运行！！");
               condition.signal();
           }catch (Exception e){
               e.printStackTrace();
           }finally {
                lock.unlock();
           }
        }
}

