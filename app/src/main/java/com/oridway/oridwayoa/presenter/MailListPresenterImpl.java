package com.oridway.oridwayoa.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oridway.oridwayoa.adapter.MailListAdapter;
import com.oridway.oridwayoa.contract.MailListContractor;
import com.oridway.oridwayoa.entity.InnerMail;
import com.oridway.oridwayoa.model.MailModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihao on 2017/8/12.
 */

public class MailListPresenterImpl implements MailListContractor.MailListPresenter {

    private MailListContractor.MailListView mView;

    private LinearLayoutManager layoutManager;

    private RecyclerView mailListView;

    private MailListAdapter mAdapter;

    private MailModel mModel;

    private List<InnerMail> mailList;

    public MailListPresenterImpl(MailListContractor.MailListView view) {
        this.mView = view;
        init();
    }

    @Override
    public void init() {
        mModel = new MailModel();
        mailList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(mView.getActivityContext(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public void buildTreeData(int treeType) {
        for (int i = 0; i < 20; i++) {
            InnerMail mail = new InnerMail();
            mail.setMailID(10000 + i);
            mail.setMailFrom(10000);
            mail.setMailTo(10001);
            mail.setMailTitle("测试用邮件" + (i + 1));
            mail.senderEmail = "591353643@qq.com";
            mail.senderName = "王妮金";
            mail.senderDesc = "研发部副部长";
            mail.setMailStatus(0);
            mail.setMailContent("这是一封测试邮件!");
            mail.setMailTag(0);
            mailList.add(mail);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void initManageList(RecyclerView mailListView) {
        this.mailListView = mailListView;
        mAdapter = new MailListAdapter(mailList);
        mailListView.setLayoutManager(layoutManager);
        mailListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
