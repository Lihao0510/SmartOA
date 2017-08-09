package com.oridway.oridwayoa.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oridway.oridcore.eventmessage.GlobalEvent;
import com.oridway.oridcore.utils.LogUtil;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.adapter.TalkPagerAdapter;
import com.oridway.oridwayoa.contract.TalkFragmentContractor;
import com.oridway.oridwayoa.presenter.TalkFragmentPresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/5.
 */

public class TalkFragment extends BaseFragment implements TalkFragmentContractor.TalkFragmentView, View.OnClickListener {

    @BindView(R.id.vp_talk)
    ViewPager viewPager;
    @BindView(R.id.tv_talkswitch_dialog)
    TextView dialogSwitch;
    @BindView(R.id.tv_talkswitch_contact)
    TextView contactSwitch;

    private View dialogView;
    private View contactView;

    private RecyclerView contactListView;

    private RecyclerView dialogListView;

    private List<View> viewList;


    private TalkPagerAdapter pagerAdapter;

    private TalkFragmentContractor.TalkFragmentPresenter mPresenter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_talk, container, false);
    }

    @Override
    protected void initFragment() {
        setPresenter(new TalkFragmentPresenterImpl(this));
        EventBus.getDefault().register(this);
        initViewPager();
        initClickListener();
    }

    private void initClickListener() {
        dialogSwitch.setOnClickListener(this);
        contactSwitch.setOnClickListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setDialogPage();
                        break;
                    case 1:
                        setContactPage();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViewPager() {
        viewList = new ArrayList<>();
        dialogView = LayoutInflater.from(getContext()).inflate(R.layout.view_talk_dialog, null);
        contactView = LayoutInflater.from(getContext()).inflate(R.layout.view_talk_contact, null);
        viewList.add(dialogView);
        viewList.add(contactView);
        pagerAdapter = new TalkPagerAdapter(getContext(), viewList);
        viewPager.setAdapter(pagerAdapter);
        contactListView = (RecyclerView) contactView.findViewById(R.id.rv_contact);
        dialogListView = (RecyclerView) dialogView.findViewById(R.id.rv_dialog);
        mPresenter.initDialogList(dialogListView);
        mPresenter.initContactList(contactListView);

    }

    public void setDialogPage() {
        dialogSwitch.setBackgroundResource(R.drawable.bg_talk_left_header_selected);
        contactSwitch.setBackgroundResource(R.drawable.bg_talk_right_header_normal);
        dialogSwitch.setTextColor(getResources().getColor(R.color.colorPrimary));
        contactSwitch.setTextColor(getResources().getColor(R.color.pureWhite));
    }

    public void setContactPage() {
        dialogSwitch.setBackgroundResource(R.drawable.bg_talk_left_header_normal);
        contactSwitch.setBackgroundResource(R.drawable.bg_talk_right_header_select);
        dialogSwitch.setTextColor(getResources().getColor(R.color.pureWhite));
        contactSwitch.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public void setPresenter(TalkFragmentContractor.TalkFragmentPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getActivityContext() {
        return getContext();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_talkswitch_dialog:
                setDialogPage();
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_talkswitch_contact:
                setContactPage();
                viewPager.setCurrentItem(1);
                break;
            default:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receivePosition(GlobalEvent event) {
        if (event.eventType == GlobalEvent.CONTACT_WILL_EXPAND) {
            final int position = (int) event.eventBody;
            LogUtil.debugLog("当前位置:" + position);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    contactListView.smoothScrollToPosition(position);
                }
            }, 500);
        }
    }

    /*
    * 取消EventBus的注册,否则会在切换Fragment时报错!
    * */
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
