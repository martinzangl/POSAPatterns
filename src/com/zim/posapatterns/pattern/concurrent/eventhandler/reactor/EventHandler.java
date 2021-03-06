package com.zim.posapatterns.pattern.concurrent.eventhandler.reactor;

/**
 * Developed by martin.zangl@globant.com
 */
public interface EventHandler {

    void handleEvent(Handler handler);

    Handler getHandler();


}
