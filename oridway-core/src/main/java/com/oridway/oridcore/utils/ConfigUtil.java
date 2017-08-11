package com.oridway.oridcore.utils;

import java.util.HashMap;

/**
 * Created by lihao on 2017/8/5.
 */

public class ConfigUtil {

    public static final String PROJECT_MANAGE = "PROJECT_MANAGE";
    public static final String MEETING_MANAGE = "MEETING_MANAGE";
    public static final String CUSTOMER_MANAGE = "CUSTOMER_MANAGE";
    public static final String FINANCE_MANAGE = "FINANCE_MANAGE";
    public static final String HR_MANAGE = "HR_MANAGE";
    public static final String SUPPLYER_MANAGE = "SUPPLYER_MANAGE";
    public static final String EQUIP_MANAGE = "EQUIP_MANAGE";
    public static final String DOCUMENT_MANAGE = "DOCUMENT_MANAGE";

    private static HashMap<String, String> configMap;

    public static HashMap<String, String> getDefaultMap() {
        if (configMap == null) {
            synchronized (ConfigUtil.class) {
                if (configMap == null) {
                    configMap = new HashMap<>();
                }
            }
        }
        return configMap;
    }

}
