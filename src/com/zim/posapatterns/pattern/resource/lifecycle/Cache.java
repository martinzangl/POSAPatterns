package com.zim.posapatterns.pattern.resource.lifecycle;

import com.zim.posapatterns.commons.Identity;
import com.zim.posapatterns.commons.Resource;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Cache {

    public void release(Resource resource);
    public Resource acquire(Identity id);
}
