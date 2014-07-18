package com.zim.posapatterns.commons;

/**
 * Developed by martin.zangl@globant.com
 *
 * FetchResourceElement class contains the main logic for retrieving
 * the details of the element of the resource. It implements
 * the Request interface, so that it can be scheduled by the
 * Scheduler.
 */
public class FetchResourceElement implements Request{

    public FetchResourceElement(String resourceId) {
    }

    @Override
    public void call() {
        // fetch elements for the resource using Partial Acquisitio
    }


    /**
     * Method that is invoked by the scheduler to see if the request can
     * be executed.
     * @return
     */
    @Override
    public boolean canRun() {
        return true;
    }
}
