package com.oridway.oridwayoa.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by lihao on 2017/8/11.
 */

public abstract class SwipeBackBaseActivity extends SwipeBackActivity {

    protected Context activityContext;
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        activityContext = this;
        ButterKnife.bind(this);
        setSwipeBackEnable(true);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initActivity();
    }

    protected abstract int setLayoutRes();

    protected abstract void initActivity();

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}
