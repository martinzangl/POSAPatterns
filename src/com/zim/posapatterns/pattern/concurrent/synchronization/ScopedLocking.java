package com.zim.posapatterns.pattern.concurrent.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by martin.zangl on 7/25/14.
 */
public class ScopedLocking {

    private Lock lock = new ReentrantLock();


    public void someMethod() {

        lock.lock();
        try {

            //do something
        } finally {
            lock.unlock();
        }
    }
}
