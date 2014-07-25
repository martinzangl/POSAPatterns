package com.zim.posapatterns.pattern.concurrent.concurrency.activeobject;

/**
 * Created by martin.zangl on 7/25/14.
 */
public class SomeTask implements MethodRequest {

    private boolean canRun = true;

    @Override
    public boolean canRun() {
        return canRun;
    }

    @Override
    public void call() {
        if(!canRun) return;

        canRun = false;

        // do something
    }
}
