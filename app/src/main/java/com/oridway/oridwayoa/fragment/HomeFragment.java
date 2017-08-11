package com.oridway.oridwayoa.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.joanzapata.iconify.widget.IconTextView;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.oridway.oridcore.utils.ConfigUtil;
import com.oridway.oridcore.utils.LogUtil;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridcore.widge.CollapseLayout;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.activity.ManageTreeActivity;
import com.oridway.oridwayoa.contract.MainFragmentContractor;
import com.oridway.oridwayoa.presenter.MainFragmentPresenterImpl;

import butterknife.BindView;

/**
 * Created by lihao on 2017/8/5.
 */

public class HomeFragment extends BaseFragment implements MainFragmentContractor.MainFragmentView, View.OnClickListener {

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
    @BindView(R.id.cl_button_group)
    CollapseLayout buttonGroupLayout;
    @BindView(R.id.cl_button_box)
    CollapseLayout menuGroupLayout;
    @BindView(R.id.rv_main)
    RecyclerView mainRecyclerView;
    @BindView(R.id.ptr_main)
    PullToRefreshLayout ptrLayout;

    @BindView(R.id.ll_menu_project)
    LinearLayout menuProject;
    @BindView(R.id.ll_menu_meeting)
    LinearLayout menuMeeting;
    @BindView(R.id.ll_menu_customer)
    LinearLayout menuCustomer;
    @BindView(R.id.ll_menu_finance)
    LinearLayout menuFinance;
    @BindView(R.id.ll_menu_hr)
    LinearLayout menuHR;
    @BindView(R.id.ll_menu_supplier)
    LinearLayout menuSupplier;
    @BindView(R.id.ll_menu_equip)
    LinearLayout menuEquip;
    @BindView(R.id.ll_menu_document)
    LinearLayout menuDocument;


    private MainFragmentContractor.MainFragmentPresenter mPresenter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initFragment() {
        setPresenter(new MainFragmentPresenterImpl(this));
        initClickListener();
        mPresenter.initNoticeList(mainRecyclerView, ptrLayout);

    }

    private void initClickListener() {
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
        ptrLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 结束刷新
                        ptrLayout.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 结束刷新
                        ptrLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mainRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    LogUtil.debugLog("scrollX:" + scrollX + "; scrollY:" + scrollY + "; oldScrollX:" + oldScrollX + "; oldScrollY:" + oldScrollY);
                }
            });
        } else {
            mainRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    //LogUtil.debugLog("上层Height:" + buttonGroupLayout.getWidgeHeight());
                    //LogUtil.debugLog("下层Height:" + menuGroupLayout.getWidgeHeight());
                    menuGroupLayout.setCollapseEnable();
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    menuGroupLayout.changeWidgeHeight((int) mPresenter.getFirstChildY());
                }
            });
        }
        menuProject.setOnClickListener(this);
        menuDocument.setOnClickListener(this);
        menuCustomer.setOnClickListener(this);
        menuEquip.setOnClickListener(this);
        menuFinance.setOnClickListener(this);
        menuHR.setOnClickListener(this);
        menuSupplier.setOnClickListener(this);
        menuMeeting.setOnClickListener(this);
    }

    @Override
    public void setPresenter(MainFragmentContractor.MainFragmentPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getActivityContext() {
        return getContext();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_menu_project:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.PROJECT_MANAGE);
                break;
            case R.id.ll_menu_meeting:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.MEETING_MANAGE);

                break;
            case R.id.ll_menu_hr:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.HR_MANAGE);

                break;
            case R.id.ll_menu_equip:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.EQUIP_MANAGE);

                break;
            case R.id.ll_menu_supplier:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.SUPPLYER_MANAGE);

                break;
            case R.id.ll_menu_finance:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.FINANCE_MANAGE);

                break;
            case R.id.ll_menu_document:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.DOCUMENT_MANAGE);

                break;
            case R.id.ll_menu_customer:
                ManageTreeActivity.startActivity(getActivityContext(), ConfigUtil.CUSTOMER_MANAGE);

                break;
            default:
                break;
        }
    }
}
