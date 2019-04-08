# ALang
![alang](https://img.shields.io/badge/jCenter-1.0.1-brightgreen.svg) [![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu)  [![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE) 

>   为了开发便捷，封装一些特殊的小语法 ...

**☆ 注意 ☆**

>   全面支持`AndroidX`，弃用`support`**

### 用法用量

*   `build.gradle`中添加依赖

    ```groovy
    dependencies {
        compile 'com.yhy.lang:alang:latestVersion'
    }
    ```



### 罗列一下

>   把小功能们都罗列一下 ...



#### 1、`Promise`

>   仿`ES6`语法，不过必须有`Lambda`表达式搭配使用，才能达到减少各种回调嵌套的问题

*   定义`Promise`，具体的执行操作

    ```java
    private Promise<String, Long> test() {
        return Promise.get((resolver, rejector) -> {
            new Thread() {
                @Override
                public void run() {
                    // 成功回调
                    resolver.resolve("哈哈哈哈");
                    // 模拟错误
                    try {
                        Thread.sleep(3000);
                        rejector.reject(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        });
    }
    ```

*   利用`Promise`处理回调，接收处理结果

    >   **最后的`execute()`必须调用**，否则`Promise`中的操作将不会执行

    ```java
    test().then(this::toast).caught(error -> toast(error.toString())).execute();
    ```



