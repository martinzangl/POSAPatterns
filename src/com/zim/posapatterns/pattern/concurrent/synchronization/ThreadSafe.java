package com.zim.posapatterns.pattern.concurrent.synchronization;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by martin.zangl on 7/25/14.
 */
public class ThreadSafe {

    public interface State{

        void doSomething();
        void setValueX(int x);
    }

    public static class StateClass implements State{

        private AtomicReference<RealState> state = new AtomicReference<>();

        @Override
        public void doSomething() {
            state.get().doSomething();
        }

        @Override
        public void setValueX(int x) {
            state.get().setValueX(x);
        }

        private class RealState implements State{

            private final int valueX;

            private RealState(int valueX) {
                this.valueX = valueX;
            }


            @Override
            public void doSomething() {
                // do something with valueX
            }

            @Override
            public void setValueX(int x) {
                if(!state.compareAndSet(this, new RealState(x))){
                    state.get().setValueX(x);
                }
            }
        }
    }

}
