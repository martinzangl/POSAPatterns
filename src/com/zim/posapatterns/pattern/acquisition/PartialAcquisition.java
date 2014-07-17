package com.zim.posapatterns.pattern.acquisition;

import com.zim.posapatterns.controller.Scheduler;
import com.zim.posapatterns.model.FetchResourceElement;
import com.zim.posapatterns.model.ResourceElement;

/**
 * Developed by martin.zangl@globant.com
 */
public class PartialAcquisition {

    private Scheduler scheduler;

    public ResourceElement getResourceDetail(String resourceId){

        ResourceElement element = new ResourceElement();

        FetchResourceElement fetchElement = new FetchResourceElement(resourceId);

        scheduler.insert(fetchElement);

        return element;
    }

}
