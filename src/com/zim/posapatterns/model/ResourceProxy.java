package com.zim.posapatterns.model;

import com.zim.posapatterns.controller.ResourceProvider;

/**
 * Developed by martin.zangl@globant.com
 */
public class ResourceProxy implements Resource {

    Resource resource;

    private void acquire(){
        resource = ResourceProvider.getInstance().getResource(Connection.class);
    }

    @Override
    public void method1() {
        if(resource == null){
            acquire();
        }
        resource.method1();
    }

    @Override
    public void method2() {
         if(resource == null){
             acquire();
         }
        resource.method2();
    }
}
