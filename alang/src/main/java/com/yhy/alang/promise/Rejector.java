package com.yhy.alang.promise;

/**
 * author : 颜洪毅
 * e-mail : yhyzgn@gmail.com
 * time   : 2019-03-23 14:13
 * version: 1.0.0
 * desc   : 反面解决方案
 */
public interface Rejector<T> {

    /**
     * 解决错误回调
     *
     * @param error 错误信息
     */
    void reject(T error);
}
