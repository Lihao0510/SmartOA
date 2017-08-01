package com.oridway.oridwayoa.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.oridway.oridcore.EventMessage.GlobalEvent;
import com.oridway.oridcore.utils.LogUtil;
import com.oridway.oridcore.utils.PrefUtil;
import com.oridway.oridwayoa.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WelcomeActivity extends AppCompatActivity {

    private static final String PREF_NAME = "appsys_prefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        EventBus.getDefault().register(this);
        LogUtil.debugLog("welcomeActivityShow");
        initWelcomeEvents();
        EventBus.getDefault().post(GlobalEvent.newEvent(GlobalEvent.WELCOME_PAGE_LOAD_COMPLETED));

    }

    private void initWelcomeEvents() {
        int launchTimes = PrefUtil.getIntProperty(getApplicationContext(), PREF_NAME, "LaunchTimes");
        if (launchTimes == 0) {
            LogUtil.debugLog("这是第一次登录,需要加载引导页!");
        } else {
            LogUtil.debugLog("这不是第一次登录,直接进入主页!");
            MainActivity.startActivity(this);
        }
        PrefUtil.setIntProperty(getApplicationContext(), PREF_NAME, "LaunchTimes", 1 + launchTimes);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void goMainActivity(GlobalEvent event) {
        if (event.eventType == GlobalEvent.EXTERNAL_COMPONENTS_LOAD_COMPLETED) {
            LogUtil.debugLog("goMainActivity");
        }
    }
}
