package com.oridway.oridcore.utils;

import android.widget.Toast;

import com.oridway.oridcore.application.CoreApplication;

/**
 * Created by lihao on 2017/8/1.
 */

public class ToastUtil {

    public static void showToast(String msg) {
        Toast.makeText(CoreApplication.getGlobalContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
