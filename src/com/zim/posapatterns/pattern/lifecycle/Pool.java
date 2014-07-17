package com.zim.posapatterns.pattern.lifecycle;

import com.zim.posapatterns.model.Resource;

/**
 * Developed by martin.zangl@globant.com
 */
public interface Pool {

    Resource acquire();
    void release(Resource resource);
}
