package com.yhy.alang.simple;

import android.os.Bundle;
import android.widget.Toast;

import com.yhy.alang.promise.Promise;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test().then(this::toast).caught(error -> toast(error.toString())).execute();
    }

    private void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private Promise<String, Long> test() {
        return Promise.get((resolver, rejector) -> {
            new Thread() {
                @Override
                public void run() {
                    resolver.resolve("哈哈哈哈");
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
}
