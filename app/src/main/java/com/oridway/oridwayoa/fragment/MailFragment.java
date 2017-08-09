package com.oridway.oridwayoa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.joanzapata.iconify.widget.IconTextView;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridwayoa.R;

import butterknife.BindView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/5.
 */

public class MailFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.sv_mail_container)
    ScrollView mailContainer;
    @BindView(R.id.itv_mail_new)
    IconTextView newMail;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mail, container, false);

    }

    @Override
    protected void initFragment() {
        OverScrollDecoratorHelper.setUpOverScroll(mailContainer);
        initClickListener();
    }

    private void initClickListener() {
        newMail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.itv_mail_new:
                ToastUtil.showToast("新建邮件!");
                break;
            default:
                break;
        }
    }
}
