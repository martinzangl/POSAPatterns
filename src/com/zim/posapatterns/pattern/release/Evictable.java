package com.zim.posapatterns.pattern.release;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Evictable<T> {

    public boolean isEvictable();
    public T info();
    public void beforeEviction();
}
