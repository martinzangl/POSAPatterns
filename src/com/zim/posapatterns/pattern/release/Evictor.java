package com.zim.posapatterns.pattern.release;

import com.zim.posapatterns.model.NetworkElement;

import java.util.Calendar;
import java.util.Date;

/**
 * Developed by martin.zangl@globant.com
 *
 * An Evictor evicts resource based on one or more strategies. The
 * Evictor is implemented as an object that runs in its own thread of
 * control. This allows it to periodically check if there are any
 * network elements that have not been accessed for a threshold time.
 */
public class Evictor implements Runnable {

    private NetworkElement[] nes;
    private int pollTime = 10;
    private Date threshold = Calendar.getInstance().getTime();

    @Override
    public void run() {
        while(true) {
            // Sleep for configured amount of time
            try {
                Thread.sleep(pollTime);
            }
            catch(InterruptedException e) { break; }

            // Assume "threshold" contains the date/time such that
            // any network element accessed before it will be
            // evicted

            // Go through all the NEs and see which ones to evict
            for(int i = 0; i < nes.length; i++) {
                NetworkElement ne = (NetworkElement)nes[i];
                if (ne.isEvictable()) {
                    Date d = (Date) ne.info();
                    if (d.before(threshold)) {
                        ne.beforeEviction ();
                        // Now remove the network element application-
                        // specifically
                    }
                }
            }
        }
    }
}
