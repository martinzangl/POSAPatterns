package com.zim.posapatterns.controller;

import com.zim.posapatterns.services.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Developed by martin.zangl@globant.com
 */
public class ResourceProvider {

    private final Map<String, Service> map;

    private static ResourceProvider sInstance = new ResourceProvider();

    public static ResourceProvider getInstance(){
        return sInstance;
    }

    private ResourceProvider() {
        map = new HashMap<String, Service>();
    }

    public <T extends Service> void addService(T service) {
        if(!map.containsKey(service.getClass().getName())) {
            map.put(service.getClass().getName(), service);
        }
    }

    public <T extends Service>Service getService(Class<T> clazz){
        return map.get(clazz.getName());
    }
}
