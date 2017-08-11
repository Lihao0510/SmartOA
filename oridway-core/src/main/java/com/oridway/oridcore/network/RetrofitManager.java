package com.oridway.oridcore.network;

import com.oridway.oridcore.utils.ConfigUtil;
import com.oridway.oridcore.utils.LogUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lihao on 2017/8/5.
 */

public class RetrofitManager {

    private volatile static RetrofitManager mInstance;

    private Retrofit mRetrofit;

    private RetrofitManager() {
        initRetrofit();
    }

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    private void initRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        LogUtil.debugLog(ConfigUtil.getDefaultMap().toString());
        if (ConfigUtil.getDefaultMap().get("IsRelease").equals("false")) {
            builder.addInterceptor(loggingInterceptor);
        }
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient client = builder.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ConfigUtil.getDefaultMap().get("BaseHttpUrl"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    public <T> T createReq(Class<T> apiClass) {
        return mRetrofit.create(apiClass);
    }

}
