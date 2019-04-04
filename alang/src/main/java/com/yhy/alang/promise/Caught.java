package com.yhy.alang.promise;

/**
 * author : 颜洪毅
 * e-mail : yhyzgn@gmail.com
 * time   : 2019-03-23 14:23
 * version: 1.0.0
 * desc   : 错误回调
 */
public interface Caught<T> {

    /**
     * 错误回调
     *
     * @param error 错误信息
     */
    void caught(T error);
}
