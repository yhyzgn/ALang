package com.yhy.alang.promise;

import android.os.Handler;
import android.os.Looper;

/**
 * author : 颜洪毅
 * e-mail : yhyzgn@gmail.com
 * time   : 2019-03-23 14:07
 * version: 1.0.0
 * desc   : Promise链式回调
 */
public class Promise<T, E> {
    private Executor<T, E> mExecutor;
    private Then<T> mThen;
    private Caught<E> mCaught;
    private Handler mHandler;

    public Promise(Executor<T, E> executor) {
        mExecutor = executor;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static <T, E> Promise<T, E> get(Executor<T, E> executor) {
        return new Promise<>(executor);
    }

    /**
     * 正确的链式队列回调
     *
     * @param then 队列回调
     * @return 当前Promise对象
     */
    public Promise<T, E> then(Then<T> then) {
        mThen = then;
        return this;
    }

    /**
     * 错误消息的队列回调
     *
     * @param caught 队列回调
     * @return 当前Promise对象
     */
    public Promise<T, E> caught(Caught<E> caught) {
        mCaught = caught;
        return this;
    }

    /**
     * 执行Promise
     */
    public void execute() {
        mExecutor.execute(data -> {
            mHandler.post(() -> {
                mThen.then(data);
            });
        }, error -> {
            mHandler.post(() -> {
                mCaught.caught(error);
            });
        });
    }
}
