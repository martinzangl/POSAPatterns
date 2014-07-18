package com.zim.posapatterns.pattern.resource.lifecycle;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Coordination {

    boolean prepare();
    void abort();
    void commit();
}
