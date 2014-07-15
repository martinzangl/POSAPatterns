package com.zim.posapatterns.pattern.aquisition;

import com.zim.posapatterns.controller.ResourceProvider;
import com.zim.posapatterns.services.Service;

/**
 * Developed by martin.zangl@globant.com
 */
public class LookupService {

    private ResourceProvider resourceProvider;

    public LookupService(){
        resourceProvider = ResourceProvider.getInstance();
    }

    public <T extends Service>Service getService(Class<T> name){
        Service service = resourceProvider.getService(name);

        if(service != null){
            return service;
        }

        try {
           // Can delegate to a creator?
            service = name.newInstance();
            resourceProvider.addService(service);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            return service;
        }

    }
}
