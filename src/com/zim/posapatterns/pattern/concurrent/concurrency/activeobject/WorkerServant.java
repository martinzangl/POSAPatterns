package com.zim.posapatterns.pattern.concurrent.concurrency.activeobject;

/**
 * Created by martin.zangl on 7/25/14.
 */
public class WorkerServant implements Servant {

    @Override
    public void handleRequest(MethodRequest request) {
            request.call();

    }
}
