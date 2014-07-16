package com.zim.posapatterns.controller;

import com.zim.posapatterns.services.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Developed by martin.zangl@globant.com
 */
public class ServiceProvider {

    private final Map<String, Service> map;

    private static ServiceProvider sInstance = new ServiceProvider();

    public static ServiceProvider getInstance(){
        return sInstance;
    }

    private ServiceProvider() {
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
