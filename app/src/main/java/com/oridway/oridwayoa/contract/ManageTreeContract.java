package com.oridway.oridwayoa.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by lihao on 2017/8/11.
 */

public interface ManageTreeContract {

    interface ManageTreeView {
        void setPresenter(ManageTreePresenter presenter);

        Context getActivityContext();
    }

    interface ManageTreePresenter {
        void init();

        void initManageList(RecyclerView manageList);
    }
}
