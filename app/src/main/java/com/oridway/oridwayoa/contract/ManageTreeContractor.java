package com.oridway.oridwayoa.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by lihao on 2017/8/11.
 */

public interface ManageTreeContractor {

    interface ManageTreeView {
        void setPresenter(ManageTreePresenter presenter);

        Context getActivityContext();
    }

    interface ManageTreePresenter {
        void init();

        void buildTreeData(String treeType);

        void initManageList(RecyclerView manageList);
    }
}
