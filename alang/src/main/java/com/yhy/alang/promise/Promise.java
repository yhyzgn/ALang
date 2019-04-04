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
public class Promise<T> {
    private Executor<T> mExecutor;
    private Then<T> mThen;
    private Caught<String> mCaught;
    private Handler mHandler;

    private Promise(Executor<T> executor) {
        mExecutor = executor;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static <T> Promise<T> get(Executor<T> executor) {
        return new Promise<>(executor);
    }

    /**
     * 正确的链式队列回调
     *
     * @param then 队列回调
     * @return 当前Promise对象
     */
    public Promise<T> then(Then<T> then) {
        mThen = then;
        return this;
    }

    /**
     * 错误消息的队列回调
     *
     * @param caught 队列回调
     * @return 当前Promise对象
     */
    public Promise<T> caught(Caught<String> caught) {
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
