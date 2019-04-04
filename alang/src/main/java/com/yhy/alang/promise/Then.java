package com.yhy.alang.promise;

/**
 * author : 颜洪毅
 * e-mail : yhyzgn@gmail.com
 * time   : 2019-03-23 14:16
 * version: 1.0.0
 * desc   : 正确回调
 */
public interface Then<T> {

    /**
     * 正确回调
     *
     * @param data 回调参数信息
     */
    void then(T data);
}
