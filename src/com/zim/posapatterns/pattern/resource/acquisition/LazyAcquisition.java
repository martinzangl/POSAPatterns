package com.zim.posapatterns.pattern.resource.acquisition;

import com.zim.posapatterns.controller.ResourceProvider;
import com.zim.posapatterns.commons.Connection;
import com.zim.posapatterns.commons.Resource;

/**
 * Developed by martin.zangl@globant.com
 */
public class LazyAcquisition implements Resource{
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
