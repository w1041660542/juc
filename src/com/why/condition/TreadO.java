package com.why.condition;

import java.util.Date;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-19 14:36
 **/
public class TreadO extends Thread{

    private BoundedBuffer boundedBuffer;
    public TreadO(BoundedBuffer boundedBuffer){
        this.boundedBuffer  = boundedBuffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Date date = (Date)boundedBuffer.take();
                System.out.println("取出: " + date);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
