package com.zim.posapatterns.controller;

/**
 * Developed by martin.zangl@globant.com
 */

import com.zim.posapatterns.commons.MessageQueue;
import com.zim.posapatterns.commons.Request;

/**
 * The Scheduler runs in the active object's thread of control.  The
 * requests that aren't inserted into the Scheduler's message queue will
 * fetch the network element's components when triggered by the
 * Scheduler.
 */
public class Scheduler implements Runnable {

    private MessageQueue queue;

    /**
     * @param numThreads the number of threas to spawn.
     * @param tm         an instance of a ThreadManager that is responsible for
     *                   managing all the threads.
     */
    public Scheduler(int numThreads, ThreadManager tm) {
        // Spawn off numThreads to be managed by ThreadManager. The
        // threads would dequeue MQRequest objects from the message queue
        // and invoke the call() method on each one
    }

    public void insert(Request request) {
        queue.insert(request);
    }

    @Override
    public void run() {

    }
}
