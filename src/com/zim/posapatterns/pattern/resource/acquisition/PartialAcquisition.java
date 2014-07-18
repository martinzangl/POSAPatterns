package com.zim.posapatterns.pattern.resource.acquisition;

import com.zim.posapatterns.controller.Scheduler;
import com.zim.posapatterns.commons.FetchResourceElement;
import com.zim.posapatterns.commons.ResourceElement;

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
