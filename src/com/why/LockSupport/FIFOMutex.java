package com.why.LockSupport;

import com.why.reentrantlock.TreadA;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-22 10:14
 **/
public class FIFOMutex {

     // 锁
     private final AtomicBoolean locked = new AtomicBoolean(false);
     // 线程存放的队列
     private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

     public void lock(){
         Thread thread = Thread.currentThread();
         waiters.add(thread);
         // 如果当前线程不在队首，或锁已被占用，则当前线程阻塞
         while (waiters.peek()!= thread || locked.compareAndSet(false,true)){
             LockSupport.park(this);
         }
         waiters.remove();

     }

     public void unlock(){
         locked.set(false);
         // 唤醒队首的线程
         LockSupport.unpark(waiters.peek());
     }



}

