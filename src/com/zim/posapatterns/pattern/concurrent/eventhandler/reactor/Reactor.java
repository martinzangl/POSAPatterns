package com.zim.posapatterns.pattern.concurrent.eventhandler.reactor;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Reactor {

    void handleEvents();
    void registerHandler(EventHandler eventHandler);
    void unregisterHandler(Handler handler);
}
