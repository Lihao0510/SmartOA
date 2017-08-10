package com.oridway.oridwayoa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
    @BindView(R.id.ll_mail_mailbox)
    LinearLayout buttonMailbox;
    @BindView(R.id.ll_mail_sended)
    LinearLayout buttonSendbox;
    @BindView(R.id.ll_mail_deleted)
    LinearLayout buttonDeletebox;
    @BindView(R.id.ll_mail_group)
    LinearLayout buttonGroup;
    @BindView(R.id.ll_mail_contact)
    LinearLayout buttonContact;
    @BindView(R.id.ll_mail_draft)
    LinearLayout buttonSecret;

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
        buttonContact.setOnClickListener(this);
        buttonDeletebox.setOnClickListener(this);
        buttonMailbox.setOnClickListener(this);
        buttonSecret.setOnClickListener(this);
        buttonSendbox.setOnClickListener(this);
        buttonGroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.itv_mail_new:
                ToastUtil.showToast("新建邮件!");
                break;
            case R.id.ll_mail_mailbox:

                break;
            case R.id.ll_mail_sended:

                break;
            case R.id.ll_mail_deleted:

                break;
            case R.id.ll_mail_group:

                break;
            case R.id.ll_mail_contact:

                break;
            case R.id.ll_mail_draft:

                break;
            default:
                break;
        }
    }
}
