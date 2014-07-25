package com.zim.posapatterns.pattern.concurrent.concurrency.halfsynchalfasync;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayDeque;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by martin.zangl on 7/25/14.
 *
 * Android AsyncTask
 */
public abstract class AsyncTask<Params, Progress, Result> {

    private final static ThreadFactory sThreadFactory = new ThreadFactory() {
        private AtomicInteger id = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "async task #" + id.incrementAndGet());
        }
    };


    private static class SerialExecutor implements Executor{
        final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();
        Runnable mActive;

        @Override
        public synchronized void execute(final Runnable command) {
           mTasks.offer(new Runnable() {
               @Override
               public void run() {
                   try {
                       command.run();
                   }finally {
                       scheduleNext();
                   }
               }
           });
        }

        synchronized void scheduleNext(){
            if((mActive = mTasks.poll()) != null){
                EXECUTOR.execute(mActive);
            }
        }
    }

    private static class AsyncTaskResult<Data> {
        final AsyncTask mTask;
        final Data[] mData;
        AsyncTaskResult(AsyncTask task, Data... data) {
            mTask = task;
            mData = data;
        }
    }

    private abstract static class WorkerRunnable<Params, Result> implements Callable<Result>{
        Params[] mParams;
    }

    private static class InternalHandler extends Handler{

    }

    public static final int CORE_POOL_SIZE = 1;
    public static final int MAXIMUM_POOL_SIZE = 10;
    public static final int KEEP_ALIVE_TIME = 1;

    private static final BlockingQueue<Runnable> poolWorkQueue = new LinkedBlockingQueue<>(100);

    private static final Executor EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE,
            MAXIMUM_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            poolWorkQueue);

    private static final SerialExecutor SERIAL_EXECUTOR = new SerialExecutor();

    private final WorkerRunnable<Params, Result> mWorkerRunnable;

    private final FutureTask<Result> mFuture;

    private final Handler mHandler = new InternalHandler();

    public AsyncTask(){
        mWorkerRunnable = new WorkerRunnable<Params, Result>() {
            @Override
            public Result call() throws Exception {
                return postResult(doInBackground(mParams));
            }
        };

        mFuture = new FutureTask<Result>(mWorkerRunnable){
            @Override
            protected void done() {
                super.done();
            }
        };
    }

    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... params){
        mWorkerRunnable.mParams = params;

        return this;
    }

    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Params... params){
       return executeOnExecutor(EXECUTOR, params);
    }

    private Result postResult(Result result){
        Message message = mHandler.obtainMessage(1,
                new AsyncTaskResult<Result>(this, result));

        message.sendToTarget();

        return result;
    }

    protected abstract Result doInBackground(Params... params);



}
