package com.oridway.oridwayoa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oridway.oridwayoa.R;

/**
 * Created by lihao on 2017/8/5.
 */

public class TalkFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_talk, container, false);
    }

    @Override
    protected void initFragment() {

    }
}
