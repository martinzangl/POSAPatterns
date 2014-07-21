package com.zim.posapatterns.pattern.concurrent.eventhandler.reactor;

import java.util.List;

/**
 * Developed by martin.zangl@globant.com
 */
public interface SyncDemultiplexer<T> {

    List<T> select();
}
