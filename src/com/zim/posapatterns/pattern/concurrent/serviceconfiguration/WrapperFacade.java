package com.zim.posapatterns.pattern.concurrent.serviceconfiguration;

import com.zim.posapatterns.controller.ApiFunctionOne;
import com.zim.posapatterns.controller.ApiFunctionTwo;

/**
 * Developed by martin.zangl@globant.com
 */
public class WrapperFacade {

    ApiFunctionOne apiFunctionOne;
    ApiFunctionTwo apiFunctionTwo;

    public void methodOne(){
        apiFunctionOne.functionOneA();
        apiFunctionTwo.functionTwoA();
    }

    public void methodThree(){
        apiFunctionOne.functionOneC();
        apiFunctionTwo.functionTwoC();
    }

    public void methodTwo(){
        apiFunctionOne.functionOneB();
        apiFunctionTwo.functionTwoB();
    }

    public void methodAll(){
        apiFunctionOne.functionOneA();
        apiFunctionOne.functionOneB();
        apiFunctionOne.functionOneC();
        apiFunctionTwo.functionTwoA();
        apiFunctionTwo.functionTwoB();
        apiFunctionTwo.functionTwoC();
    }
}
