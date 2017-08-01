package com.oridway.oridcore.utils;

import android.util.Log;

/**
 * Created by lihao on 2017/8/1.
 */

public class LogUtil {

    private static final String LOG_TAG = "ORIDWAY_OA";

    public static void debugLog(String msg) {
        Log.d(LOG_TAG, msg);
    }

    public static void errorLog(String msg) {
        Log.e(LOG_TAG, msg);
    }

    public static void infoLog(String msg) {
        Log.i(LOG_TAG, msg);
    }
}
