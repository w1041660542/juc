package com.why.condition;

import java.util.Date;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-19 14:36
 **/
public class TreadQ extends Thread{

    private BoundedBuffer boundedBuffer;
    public TreadQ(BoundedBuffer boundedBuffer){
        this.boundedBuffer  = boundedBuffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Date date = new Date();
                boundedBuffer.put(date);
                System.out.println("存入: " +date);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

