package com.zim.posapatterns.pattern.concurrent.eventhandler.reactor;

/**
 * Developed by martin.zangl@globant.com
 */
public class EventHandlerImp implements EventHandler {

    private Handler handler;

    public EventHandlerImp(Reactor reactor /* other params */){
        reactor.registerHandler(this);
    }

    @Override
    public void handleEvent(Handler handler) {
        this.handler = handler;
    }

    @Override
    public Handler getHandler() {
        return handler;
    }
}
