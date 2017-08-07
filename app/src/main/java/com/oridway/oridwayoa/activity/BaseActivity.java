package com.oridway.oridwayoa.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by lihao on 2017/8/2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context activityContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        activityContext = this;
        ButterKnife.bind(this);
        initActivity();
    }

    protected abstract int setLayoutRes();

    protected abstract void initActivity();

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
