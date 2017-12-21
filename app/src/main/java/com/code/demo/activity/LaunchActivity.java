package com.code.demo.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.code.demo.MainActivity;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * 启动页面
 * Created by liunian on 2017/12/20.
 */

public class LaunchActivity extends Basectivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                       startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                       finish();
                    }
                });
    }
}
