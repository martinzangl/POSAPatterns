package com.zim.posapatterns.pattern.concurrent.eventhandler.act;

/**
 * Created by martin.zangl on 7/22/14.
 */
public class ServiceExample implements Service {

    ACT handler;

    @Override
    public void subscribe(ACT handler) {
        this.handler = handler;
    }
}
