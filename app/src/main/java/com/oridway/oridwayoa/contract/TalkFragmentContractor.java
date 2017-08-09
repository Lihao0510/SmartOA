package com.oridway.oridwayoa.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by lihao on 2017/8/9.
 */

public interface TalkFragmentContractor {

    interface TalkFragmentView {

        void setPresenter(TalkFragmentPresenter presenter);

        Context getActivityContext();

    }

    interface TalkFragmentPresenter {
        void init();

        void initDialogList(RecyclerView dialogList);

        void initContactList(RecyclerView contactList);
    }

}
