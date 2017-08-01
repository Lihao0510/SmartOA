package com.oridway.oridcore.application;

import android.app.Application;
import android.content.Context;

import com.oridway.oridcore.EventMessage.GlobalEvent;
import com.oridway.oridcore.exception.CrashHandler;
import com.oridway.oridcore.utils.AssetUtil;
import com.oridway.oridcore.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import io.realm.Realm;

/**
 * Created by lihao on 2017/8/1.
 */

public class CoreApplication extends Application {

    private static Context applicationContext;
    private HashMap<String, String> appProperties;

    @Override
    public void onCreate() {
        super.onCreate();
        initLocalSetting();

    }

    public static Context getGlobalContext() {
        return applicationContext;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initThirdPartyUtil(GlobalEvent event) {
        if (event.eventType == GlobalEvent.WELCOME_PAGE_LOAD_COMPLETED) {
            LogUtil.debugLog("initThirdPartyUtil");

            Realm.init(applicationContext);
            CrashHandler.getInstance().init(applicationContext);
            EventBus.getDefault().post(GlobalEvent.newEvent(GlobalEvent.EXTERNAL_COMPONENTS_LOAD_COMPLETED));
        }
    }

    private void initLocalSetting() {
        EventBus.getDefault().register(this);
        appProperties = new HashMap<>();
        applicationContext = getApplicationContext();
        AssetUtil.loadPropsFromAsset(applicationContext, "app_env.properties", appProperties);
    }
}
