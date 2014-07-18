package com.zim.posapatterns.model;

import com.zim.posapatterns.pattern.release.Evictable;

import java.util.Date;

/**
 * Developed by martin.zangl@globant.com
 */
public class NetworkElement implements Evictable<Date> {


    private Date lastAccess;

    @Override
    public boolean isEvictable() {
        return true;
    }

    @Override
    public Date info() {
        return lastAccess;
    }

    @Override
    public void beforeEviction() {
    }
}
