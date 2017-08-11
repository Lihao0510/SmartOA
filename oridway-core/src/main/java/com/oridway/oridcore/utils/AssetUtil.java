package com.oridway.oridcore.utils;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lihao on 2017/8/1.
 */

public class AssetUtil {

    // 从assets 文件夹中获取文件并读取数据
    public static void loadPropsFromAsset(Context context, String fileName, Map<String, String> propertyMap) {
        propertyMap.clear();
        Properties properties = new Properties();
        InputStream in = null;

        try {
            in = context.getResources().getAssets().open(fileName);
            properties.load(in);

            propertyMap.put("BaseHttpUrl", properties.getProperty("BaseHttpUrl", "127.0.0.1:8080"));
            propertyMap.put("VersionCode", properties.getProperty("VersionCode", "1000"));
            propertyMap.put("IsRelease", properties.getProperty("IsRelease", "true"));

            in.close();
            properties = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
