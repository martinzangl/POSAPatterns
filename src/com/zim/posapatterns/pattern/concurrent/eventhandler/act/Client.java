package com.zim.posapatterns.pattern.concurrent.eventhandler.act;

/**
 * Created by martin.zangl on 7/22/14.
 */
public class Client {

    ACT act = new ACTExample();

    Client(){

    }

    void start(){
        CompletionEvent completionEvent = new CompletionEvent() {
            @Override
            public void onCompleted() {

            }
        };



        act.register(completionEvent);

    }
}
