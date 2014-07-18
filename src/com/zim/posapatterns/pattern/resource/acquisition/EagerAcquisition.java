package com.zim.posapatterns.pattern.resource.acquisition;

import com.zim.posapatterns.controller.ResourceProvider;
import com.zim.posapatterns.commons.Connection;
import com.zim.posapatterns.commons.Resource;

/**
 * Developed by martin.zangl@globant.com
 */
public class EagerAcquisition implements Resource {

    Resource resource;

    public EagerAcquisition() {
        resource = ResourceProvider.getInstance().getResource(Connection.class);
    }

    @Override
    public void method1() {

        resource.method1();
    }

    @Override
    public void method2() {
        resource.method2();
    }
}
