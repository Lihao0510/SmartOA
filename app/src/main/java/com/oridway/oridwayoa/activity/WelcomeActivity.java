package com.oridway.oridwayoa.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.oridway.oridcore.eventmessage.GlobalEvent;
import com.oridway.oridcore.utils.LogUtil;
import com.oridway.oridcore.utils.PrefUtil;
import com.oridway.oridwayoa.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;

public class WelcomeActivity extends BaseActivity {

    private static final String PREF_NAME = "appsys_prefs";

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initActivity() {
        LogUtil.debugLog("welcomeActivityShow");
        initWelcomeEvents();
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(GlobalEvent.newEvent(GlobalEvent.WELCOME_PAGE_LOAD_COMPLETED));

    }

    private void initWelcomeEvents() {
        int launchTimes = PrefUtil.getIntProperty(getApplicationContext(), PREF_NAME, "LaunchTimes");

        if (launchTimes == 0) {
            LogUtil.debugLog("这是第一次登录,需要加载引导页!");
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.startActivity(WelcomeActivity.this);
                    WelcomeActivity.this.finish();
                }
            }, 2400);
            LogUtil.debugLog("这不是第一次登录,直接进入主页!");
        }
        PrefUtil.setIntProperty(getApplicationContext(), PREF_NAME, "LaunchTimes", 1 + launchTimes);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void goMainActivity(GlobalEvent event) {
        if (event.eventType == GlobalEvent.EXTERNAL_COMPONENTS_LOAD_COMPLETED) {
            LogUtil.debugLog("goMainActivity");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
