package com.zim.posapatterns.pattern.lifecycle;

import com.zim.posapatterns.model.Identity;
import com.zim.posapatterns.model.Resource;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Cache {

    public void release(Resource resource);
    public Resource acquire(Identity id);
}
