package com.oridway.oridwayoa.activity;

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

public class WelcomeActivity extends BaseActivity {

    private static final String PREF_NAME = "appsys_prefs";

    @BindView(R.id.tv_welcome)
    TextView welcomeText;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initActivity() {
        LogUtil.debugLog("welcomeActivityShow");
        initWelcomeEvents();
        EventBus.getDefault().post(GlobalEvent.newEvent(GlobalEvent.WELCOME_PAGE_LOAD_COMPLETED));

    }

    private void initWelcomeEvents() {
        welcomeText.setText("我艹,成功了!");
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
