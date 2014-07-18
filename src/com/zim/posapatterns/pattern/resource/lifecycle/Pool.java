package com.zim.posapatterns.pattern.resource.lifecycle;

import com.zim.posapatterns.commons.Resource;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Pool {

    Resource acquire();
    void release(Resource resource);
}
