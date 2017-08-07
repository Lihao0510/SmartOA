package com.oridway.oridwayoa.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabWidget;
import android.widget.TextView;

import com.oridway.oridcore.network.RetrofitManager;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.api.UserService;
import com.oridway.oridwayoa.entity.ResponseObject;
import com.oridway.oridwayoa.entity.SysUser;
import com.oridway.oridwayoa.fragment.CenterFragment;
import com.oridway.oridwayoa.fragment.HomeFragment;
import com.oridway.oridwayoa.fragment.MailFragment;
import com.oridway.oridwayoa.fragment.TalkFragment;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    public static final String TAB_HOME = "TAB_HOME";
    public static final String TAB_TALK = "TAB_TALK";
    public static final String TAB_MAIL = "TAB_MAIL";
    public static final String TAB_CENTER = "TAB_CENTER";

    @BindView(R.id.ft_tabhost)
    FragmentTabHost mTabHost;

    private TabWidget mTabWidget;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initActivity() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.translucent));
        }
        initFragmentHost();
    }

    private void initFragmentHost() {
        mTabHost.setup(activityContext, getSupportFragmentManager(), R.id.fl_fragment_container);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_HOME).setIndicator(getTabItemView("首页", R.drawable.selector_tab_home)), HomeFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_TALK).setIndicator(getTabItemView("沟通", R.drawable.selector_tab_talk)), TalkFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_MAIL).setIndicator(getTabItemView("邮件", R.drawable.selector_tab_mail)), MailFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_CENTER).setIndicator(getTabItemView("我的", R.drawable.selector_tab_center)), CenterFragment.class, null);

        mTabWidget = mTabHost.getTabWidget();
        mTabWidget.setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabWidget.setBackgroundResource(R.color.pureWhite);
        mTabWidget.setPadding(0, 20, 0, 20);
    }

    private View getTabItemView(String tabTitle, int drawableResId) {
        View tabView = getLayoutInflater().inflate(R.layout.item_tab_indicator, null, false);
        ((ImageView) tabView.findViewById(R.id.iv_indicator_image)).setImageResource(drawableResId);
        ((TextView) tabView.findViewById(R.id.tv_indicator_text)).setText(tabTitle);
        return tabView;
    }

}
