package com.zim.posapatterns.pattern.concurrent.concurrency.activeobject;

import java.util.concurrent.BlockingQueue;

/**
 * Created by martin.zangl on 7/25/14.
 */
public class Scheduler {

    // the active list
    private final BlockingQueue<MethodRequest> queue;

    public Scheduler(BlockingQueue<MethodRequest> queue) {
        this.queue = queue;
    }


    public void loop() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        MethodRequest request = queue.take();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
