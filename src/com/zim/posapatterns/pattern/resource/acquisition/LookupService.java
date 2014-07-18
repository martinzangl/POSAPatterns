package com.zim.posapatterns.pattern.resource.acquisition;

import com.zim.posapatterns.controller.ServiceProvider;
import com.zim.posapatterns.services.Service;

/**
 * Developed by martin.zangl@globant.com
 */
public class LookupService {

    private ServiceProvider serviceProvider;

    public LookupService(){
        serviceProvider = ServiceProvider.getInstance();
    }

    public <T extends Service>Service getService(Class<T> name){
        Service service = serviceProvider.getService(name);

        if(service != null){
            return service;
        }

        try {
           // Can delegate to a creator?
            service = name.newInstance();
            serviceProvider.addService(service);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            return service;
        }

    }
}
