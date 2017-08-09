package com.oridway.oridwayoa.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

/**
 * Created by lihao on 2017/8/7.
 */

public interface MainFragmentContractor {

    interface MainFragmentView {
        void setPresenter(MainFragmentPresenter presenter);

        Context getActivityContext();

    }


    interface MainFragmentPresenter {
        void getEnterpriseNotice();

        void initNoticeList(RecyclerView recyclerView, PullToRefreshLayout ptrLayout);

        void init();

        float getFirstChildY();
    }
}
