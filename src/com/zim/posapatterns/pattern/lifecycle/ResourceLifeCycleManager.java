package com.zim.posapatterns.pattern.lifecycle;

import com.zim.posapatterns.model.*;

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

    public ResourceGroup createGroup(String idGroup, ManagedResource[] resources){
        ResourceGroup group = new ResourceGroup(idGroup);

        for (ManagedResource resource: resources){
            group.add(resource, resource.type());
        }

        return group;
    }

    public void addResourceToGroup (ManagedResource resource, ResourceGroup group) {
        group.add (resource, resource.type ());
    }

    public boolean release (ResourceGroup group) {
        // Iterate over all resources in the group and release them using
        // two-phase-commit protocol
        // ...
        return true;
    }

    public void release (ManagedResource resource) {
        ResourceGroup group = this.findGroup (resource);
        if (group != null)
            group.release ();
    }

    public void setFactory (ResourceType type, ResourceFactory factory) {
        resourceFactories.put (type, factory);
    }


    private ResourceGroup findGroup(ManagedResource resource) {
        // Find the group to which this resource belongs to
        // ..
        return null;
    }
}
