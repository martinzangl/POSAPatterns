package com.zim.posapatterns.controller;

import com.zim.posapatterns.pattern.resource.lifecycle.Coordination;
import com.zim.posapatterns.pattern.resource.lifecycle.Coordinator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Developed by martin.zangl@globant.com
 */
public class ServiceCoordinator implements Coordinator {

    private boolean taskInProgress;
    private List<Coordination> tasks = new ArrayList<Coordination>();


    @Override
    public void beginTask() {
        taskInProgress = true;
    }

    @Override
    public void register(Coordination participant) {
        if (!taskInProgress) return;
        if (!tasks.contains(participant)) {
            tasks.add(participant);
        }
    }

    @Override
    public boolean commitTask() {
        if (!taskInProgress) return false;

        ArrayList<Coordination> prepareCompleted = new ArrayList<>();

        Iterator<Coordination> it = tasks.iterator();

        while (it.hasNext()) {
            Coordination participant = it.next();
            boolean success = participant.prepare();

            if (success) {
                prepareCompleted.add(participant);
            } else {
                // Ask all participants that have completed prepare phase
                // successfully to abort.
                Iterator<Coordination> iterator = tasks.iterator();
                while (iterator.hasNext()) {
                    Coordination p = (Coordination) iterator.next();
                    p.abort();
                }
                tasks.clear();
                taskInProgress = false;
                return false;
            }
        }
        for (Iterator i= tasks.iterator() ;i.hasNext() ;) {
            Coordination participant = (Coordination) i.next();
            participant.commit ();
        } // end for
        tasks.clear ();
        taskInProgress = false;

        return true;
    }
}
