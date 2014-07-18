package com.zim.posapatterns.pattern.concurrent.eventhandler.reactor;

/**
 * Developed by martin.zangl@globant.com
 */
public class ReactorImp implements Reactor {

    @Override
    public void handleEvents() {

    }

    @Override
    public void registerHandler(EventHandler eventHandler) {
        Handler handler = eventHandler.getHandler();
        //
    }

    @Override
    public void unregisterHandler(Handler handler) {

    }
}
