package com.why.condition;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-19 14:42
 **/
public class App {

    public static void main(String[] args) {

        BoundedBuffer boundedBuffer = new BoundedBuffer();
        TreadQ q = new TreadQ(boundedBuffer);
        TreadO o = new TreadO(boundedBuffer);
        q.start();
        o.start();








    }
}

