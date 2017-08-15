package com.oridway.oridwayoa.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by lihao on 2017/8/12.
 */

public interface MailListContractor {

    interface MailListView {
        void setPresenter(MailListPresenter presenter);

        Context getActivityContext();
    }

    interface MailListPresenter {
        void init();

        void buildTreeData(int treeType);

        void initManageList(RecyclerView mailListView);
    }
}
