package com.zim.posapatterns.model;

import java.util.Iterator;

/**
 * Developed by martin.zangl@globant.com
 */
public class ResourceGroup implements Iterable<ManagedResource>{

    private String groupID;


    public ResourceGroup(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void release(){
        //
    }

    public void add(ManagedResource resource, ResourceType type){
        //
    }


    @Override
    public Iterator<ManagedResource> iterator() {
        return null;
    }
}
