package com.zim.posapatterns.pattern.lifecycle;

import com.zim.posapatterns.model.Resource;
import com.zim.posapatterns.model.ResourceFactory;
import com.zim.posapatterns.model.ResourceType;

import java.util.HashMap;

/**
 * Developed by martin.zangl@globant.com
 */
public class ResourceLifeCycleManager {

    // HashMap of resource groups
    private HashMap resourceGroups;

    // HashMap of resource factories
    private HashMap<ResourceType, ResourceFactory> resourceFactories;

    // HashMap of different resource pools, whose keys are
    // ResourceType and whose values are the actual pools.
    private HashMap<ResourceType, Pool> resourcePools;

    public ResourceLifeCycleManager() {
        // Create and set up all the appropriate pools and factories
    }

    public Resource acquire(ResourceType type) {
        Pool pool = resourcePools.get(type);
        if (pool != null) {
            Resource resource = pool.acquire();
            if (resource != null) return resource;
        }

        ResourceFactory factory = resourceFactories.get(type);
        if (factory != null) return (Resource) factory.create();
        else {
            //handle errors
        }
        return null;
    }
}
