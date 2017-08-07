package com.oridway.oridwayoa.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.joanzapata.iconify.widget.IconTextView;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridwayoa.R;

import butterknife.BindView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/5.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.icon_alarm)
    IconTextView alarmIcon;
    @BindView(R.id.icon_scan)
    IconTextView scanIcon;
    @BindView(R.id.ll_button_daka)
    LinearLayout buttonDaka;
    @BindView(R.id.ll_button_qingjia)
    LinearLayout buttonQingjia;
    @BindView(R.id.ll_button_fankui)
    LinearLayout buttonFankui;
    @BindView(R.id.ll_button_chongzhi)
    LinearLayout buttonChongzhi;
    @BindView(R.id.ll_button_group)
    LinearLayout buttonGroupLayout;
    @BindView(R.id.sv_content)
    ScrollView contentScrollView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initFragment() {
        alarmIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonGroupLayout.setVisibility(View.GONE);
            }
        });
        scanIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonGroupLayout.setVisibility(View.VISIBLE);
            }
        });
        buttonDaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("点击了扫描!");

            }
        });
        buttonChongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("点击了扫描!");

            }
        });
        buttonFankui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("点击了扫描!");

            }
        });
        buttonQingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("点击了扫描!");

            }
        });
        OverScrollDecoratorHelper.setUpOverScroll(contentScrollView);
    }
}
