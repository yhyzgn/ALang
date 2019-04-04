package com.yhy.alang.promise;

/**
 * author : 颜洪毅
 * e-mail : yhyzgn@gmail.com
 * time   : 2019-03-23 14:12
 * version: 1.0.0
 * desc   : 正面解决方案
 */
public interface Resolver<T> {

    /**
     * 解决回调
     *
     * @param data 回调信息
     */
    void resolve(T data);
}
