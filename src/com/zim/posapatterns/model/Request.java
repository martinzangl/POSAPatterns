package com.zim.posapatterns.model;

/**
 * Developed by martin.zangl@globant.com
 */

/**
 * Command interface to be handled by the active object.
 */
public interface Request {

    /**
     * Method that is invoked by the scheduler and does the actual work.
     */
    public void call();

    /**
     * Method that is invoked by the scheduler to see if the request can
     * be executed.
     * @return boolean true if request can be executed, false otherwise.
     */
    public boolean canRun();

}
