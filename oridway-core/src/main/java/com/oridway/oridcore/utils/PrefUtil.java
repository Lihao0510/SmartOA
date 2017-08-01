package com.oridway.oridcore.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lihao on 2017/8/1.
 */

public class PrefUtil {

    public static String getStringProperty(Context context, String prefName, String propertyName) {
        SharedPreferences preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        String result = preferences.getString(propertyName, "");
        preferences = null;
        return result;
    }

    public static boolean getBooleanProperty(Context context, String prefName, String propertyName) {
        SharedPreferences preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        boolean result = preferences.getBoolean(propertyName, false);
        preferences = null;
        return result;
    }

    public static int getIntProperty(Context context, String prefName, String propertyName) {
        SharedPreferences preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        int result = preferences.getInt(propertyName, 0);
        preferences = null;
        return result;
    }

    public static void setStringProperty(Context context, String prefName, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
        editor = null;
    }

    public static void setIntProperty(Context context, String prefName, String key, int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.commit();
        editor = null;
    }

    public static void setBooleanProperty(Context context, String prefName, String key, boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.commit();
        editor = null;
    }

}
