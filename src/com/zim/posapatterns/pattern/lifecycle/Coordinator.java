package com.zim.posapatterns.pattern.lifecycle;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Coordinator {

    void beginTask();
    void register(Coordination participant);
    boolean commitTask();
}
