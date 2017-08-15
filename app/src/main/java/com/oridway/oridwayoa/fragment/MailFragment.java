package com.oridway.oridwayoa.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.joanzapata.iconify.widget.IconTextView;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.activity.MailListActivity;

import butterknife.BindView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/5.
 */

public class MailFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.sv_mail_container)
    ScrollView mailContainer;
    @BindView(R.id.itv_mail_refresh)
    IconTextView refreshMail;
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
    @BindView(R.id.fab_mail_new)
    FloatingActionButton newMail;

    private long lastPressTime = 0L;

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
        refreshMail.setOnClickListener(this);
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

        Long nowPressTime = System.currentTimeMillis();
        if (nowPressTime - lastPressTime <= 500) {
            lastPressTime = nowPressTime;
            return;
        }
        lastPressTime = nowPressTime;

        switch (v.getId()) {
            case R.id.itv_mail_refresh:
                ToastUtil.showToast("刷新邮件!");
                break;
            case R.id.fab_mail_new:
                ToastUtil.showToast("新建邮件!");
                break;
            case R.id.ll_mail_mailbox:
                MailListActivity.startActivity(mActivity, MailListActivity.RECEIVE_BOX);
                break;
            case R.id.ll_mail_sended:
                MailListActivity.startActivity(mActivity, MailListActivity.SEND_BOX);
                break;
            case R.id.ll_mail_deleted:
                MailListActivity.startActivity(mActivity, MailListActivity.DELETE_BOX);
                break;
            case R.id.ll_mail_group:
                MailListActivity.startActivity(mActivity, MailListActivity.GROUP_BOX);
                break;
            case R.id.ll_mail_contact:
                MailListActivity.startActivity(mActivity, MailListActivity.CONTACT_BOX);
                break;
            case R.id.ll_mail_draft:
                MailListActivity.startActivity(mActivity, MailListActivity.SECRET_BOX);
                break;
            default:
                break;
        }
    }
}
