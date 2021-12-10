package com.why.reentrantlock;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-14 15:55
 **/
public class TreadA extends Thread{

    private  MyService myService;
    public TreadA(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.awit();
    }

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        TreadA threadA = new TreadA(myService);
        threadA.start();

        Thread.sleep(5000);
        myService.signal();
    }
}

