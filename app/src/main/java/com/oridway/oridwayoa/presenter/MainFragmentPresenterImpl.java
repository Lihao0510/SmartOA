package com.oridway.oridwayoa.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.jwenfeng.library.pulltorefresh.ViewStatus;
import com.oridway.oridcore.utils.LogUtil;
import com.oridway.oridwayoa.adapter.NoticeAdapter;
import com.oridway.oridwayoa.contract.MainFragmentContractor;
import com.oridway.oridwayoa.entity.EnterpriseNotice;
import com.oridway.oridwayoa.entity.ResponseObject;
import com.oridway.oridwayoa.model.MainFragmentModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lihao on 2017/8/7.
 */

public class MainFragmentPresenterImpl implements MainFragmentContractor.MainFragmentPresenter {

    private MainFragmentModel mModel;
    private MainFragmentContractor.MainFragmentView mView;
    private LinearLayoutManager layoutManager;
    private NoticeAdapter noticeAdapter;

    private List<EnterpriseNotice> noticeList;

    public MainFragmentPresenterImpl(MainFragmentContractor.MainFragmentView view) {
        mView = view;
        init();
    }

    @Override
    public void getEnterpriseNotice() {

    }

    @Override
    public void initNoticeList(final RecyclerView recyclerView, final PullToRefreshLayout ptrLayout) {
        ptrLayout.showView(ViewStatus.LOADING_STATUS);
        noticeAdapter = new NoticeAdapter(noticeList);
        noticeAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(noticeAdapter);

        mModel.getNoticeList(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseObject<List<EnterpriseNotice>>>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.debugLog("获取Notice完成!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.errorLog(e.toString());
                        ptrLayout.showView(ViewStatus.ERROR_STATUS);
                    }

                    @Override
                    public void onNext(ResponseObject<List<EnterpriseNotice>> listResponseObject) {
                        if (listResponseObject.getStatus() == 1) {
                            ptrLayout.showView(ViewStatus.CONTENT_STATUS);
                            noticeAdapter.addData(listResponseObject.getResult());
                        } else {
                            LogUtil.errorLog("失败了!");
                        }
                    }
                });
    }

    @Override
    public void init() {
        mModel = new MainFragmentModel();
        noticeList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(mView.getActivityContext(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public float getFirstChildY() {
        int position = layoutManager.findFirstVisibleItemPosition();
        return layoutManager.getChildAt(0).getHeight() * layoutManager.findFirstVisibleItemPosition() - layoutManager.findViewByPosition(position).getTop();
    }
}
