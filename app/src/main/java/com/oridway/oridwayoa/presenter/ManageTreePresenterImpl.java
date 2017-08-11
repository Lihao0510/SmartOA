package com.oridway.oridwayoa.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oridway.oridwayoa.contract.ManageTreeContract;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/11.
 */

public class ManageTreePresenterImpl implements ManageTreeContract.ManageTreePresenter {

    private ManageTreeContract.ManageTreeView mView;
    private LinearLayoutManager layoutManager;

    public ManageTreePresenterImpl(ManageTreeContract.ManageTreeView view) {
        this.mView = view;
        init();
    }

    @Override
    public void init() {
        layoutManager = new LinearLayoutManager(mView.getActivityContext(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public void initManageList(RecyclerView manageList) {
        manageList.setLayoutManager(layoutManager);
        OverScrollDecoratorHelper.setUpOverScroll(manageList, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }


}
