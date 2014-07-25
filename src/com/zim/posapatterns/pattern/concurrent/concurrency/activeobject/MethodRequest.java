package com.zim.posapatterns.pattern.concurrent.concurrency.activeobject;

/**
 * Created by martin.zangl on 7/25/14.
 */
public interface MethodRequest {

    boolean canRun();
    void call();
}
