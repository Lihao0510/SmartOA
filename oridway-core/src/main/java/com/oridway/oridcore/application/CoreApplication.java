package com.oridway.oridcore.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.EntypoModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.joanzapata.iconify.fonts.MeteoconsModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.joanzapata.iconify.fonts.TypiconsModule;
import com.joanzapata.iconify.fonts.WeathericonsModule;
import com.oridway.oridcore.eventmessage.GlobalEvent;
import com.oridway.oridcore.exception.CrashHandler;
import com.oridway.oridcore.icon.SmartIconModule;
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
    private static HashMap<String, String> appProperties;

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
            Iconify.with(new FontAwesomeModule())
                    .with(new EntypoModule())
                    .with(new TypiconsModule())
                    .with(new MaterialModule())
                    .with(new MaterialCommunityModule())
                    .with(new MeteoconsModule())
                    .with(new WeathericonsModule())
                    .with(new SimpleLineIconsModule())
                    .with(new IoniconsModule());
            EventBus.getDefault().post(GlobalEvent.newEvent(GlobalEvent.EXTERNAL_COMPONENTS_LOAD_COMPLETED));
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);

    }

    private void initLocalSetting() {
        EventBus.getDefault().register(this);
        appProperties = new HashMap<>();
        applicationContext = getApplicationContext();
        AssetUtil.loadPropsFromAsset(applicationContext, "app_env.properties", appProperties);
        LogUtil.debugLog("initLocalSettingFinished");
    }

    public static String getAppConfig(String configKey) {
        return appProperties.get(configKey);
    }
}
