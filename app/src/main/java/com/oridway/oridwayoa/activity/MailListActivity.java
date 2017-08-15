package com.oridway.oridwayoa.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.contract.MailListContractor;
import com.oridway.oridwayoa.presenter.MailListPresenterImpl;

import butterknife.BindView;


public class MailListActivity extends SwipeBackBaseActivity implements View.OnClickListener, MailListContractor.MailListView {

    public static final String MAIL_KIND = "MAIL_KIND";
    public static final int RECEIVE_BOX = 0;
    public static final int SEND_BOX = 1;
    public static final int DELETE_BOX = 2;
    public static final int GROUP_BOX = 3;
    public static final int CONTACT_BOX = 4;
    public static final int SECRET_BOX = 5;

    @BindView(R.id.itv_toolbar_back)
    IconTextView buttonBack;
    @BindView(R.id.tv_toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.ptr_mail)
    PullToRefreshLayout ptrLayout;
    @BindView(R.id.rv_mail_list)
    RecyclerView mailListView;

    private int mailKind;

    private MailListContractor.MailListPresenter mPresenter;

    public static void startActivity(Context context, int mailKind) {
        Intent intent = new Intent(context, MailListActivity.class);
        intent.putExtra(MAIL_KIND, mailKind);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_mail_list;
    }

    @Override
    protected void initActivity() {
        setPresenter(new MailListPresenterImpl(this));
        initClickListener();
        mPresenter.initManageList(mailListView);
        initMailBox();
    }

    private void initClickListener() {
        buttonBack.setOnClickListener(this);
    }

    private void initMailBox() {
        mailKind = getIntent().getIntExtra(MAIL_KIND, 0);
        mPresenter.buildTreeData(mailKind);
        switch (mailKind) {
            case RECEIVE_BOX:
                toolbarTitle.setText("收件箱");
                break;
            case SEND_BOX:
                toolbarTitle.setText("已发出邮件");
                break;
            case DELETE_BOX:
                toolbarTitle.setText("已删除邮件");
                break;
            case GROUP_BOX:
                toolbarTitle.setText("群邮件");
                break;
            case CONTACT_BOX:
                toolbarTitle.setText("邮件联系人");
                break;
            case SECRET_BOX:
                toolbarTitle.setText("草稿箱");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.itv_toolbar_back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void setPresenter(MailListContractor.MailListPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getActivityContext() {
        return activityContext;
    }
}
