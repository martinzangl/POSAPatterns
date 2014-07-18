package com.zim.posapatterns.controller;

import android.content.res.Resources;
import com.zim.posapatterns.commons.Identity;
import com.zim.posapatterns.commons.Resource;
import com.zim.posapatterns.pattern.resource.lifecycle.Cache;

import java.util.HashMap;

/**
 * Developed by martin.zangl@globant.com
 */
public class CacheImp implements Cache {

    private HashMap<String, Resource> map;

    @Override
    public void release(Resource resource) {
        String id = resource.getIdentity().getId();
        map.put(id, resource);
    }

    @Override
    public Resource acquire(Identity id) {
        Resource resource = map.get(id.getId());

        if(resource == null){
            throw new Resources.NotFoundException();
        }
        return resource;
    }
}
