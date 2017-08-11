package com.oridway.oridcore.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lihao on 2017/8/1.
 */

public class ToastUtil {

    public static Context appContext;

    public static void showToast(String msg) {
        Toast.makeText(appContext, msg, Toast.LENGTH_SHORT).show();
    }

}
