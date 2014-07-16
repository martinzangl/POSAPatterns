package com.zim.posapatterns.controller;

import com.zim.posapatterns.model.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * Developed by martin.zangl@globant.com
 */
public class ResourceProvider {

    private final Map<String, Resource> map;

    private static ResourceProvider sInstance = new ResourceProvider();

    public static ResourceProvider getInstance() {
        return sInstance;
    }

    private ResourceProvider() {
        map = new HashMap<String, Resource>();
    }

    public <T extends Resource> void addResource(T resource) {
        if (!map.containsKey(resource.getClass().getName())) {
            map.put(resource.getClass().getName(), resource);
        }
    }

    public <T extends Resource> Resource getResource(Class<T> clazz) {
        return map.get(clazz.getName());
    }
}
