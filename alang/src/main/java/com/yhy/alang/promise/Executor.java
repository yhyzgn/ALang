package com.yhy.alang.promise;

/**
 * author : 颜洪毅
 * e-mail : yhyzgn@gmail.com
 * time   : 2019-03-23 14:20
 * version: 1.0.0
 * desc   : 执行器
 */
public interface Executor<T, E> {

    /**
     * 执行操作
     *
     * @param resolver 正面解决方案
     * @param rejector 反面解决方案
     */
    void execute(Resolver<T> resolver, Rejector<E> rejector);
}
