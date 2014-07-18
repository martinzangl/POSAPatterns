package com.zim.posapatterns.commons;

import com.zim.posapatterns.pattern.resource.release.Evictable;

import java.util.Date;

/**
 * Developed by martin.zangl@globant.com
 */
public class NetworkComponent implements Evictable<Date> {

    private NetworkComponent [] components;
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
        for (int i = 0; i < components.length; i++) {
            components[i].beforeEviction ();
        }
    }

}
