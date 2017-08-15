package com.oridway.oridwayoa.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
import com.oridway.oridcore.utils.ConfigUtil;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.contract.ManageTreeContractor;
import com.oridway.oridwayoa.presenter.ManageTreePresenterImpl;

import butterknife.BindView;

public class ManageTreeActivity extends SwipeBackBaseActivity implements ManageTreeContractor.ManageTreeView, View.OnClickListener {

    private static final String MANAGE_TYPE = "MANAGE_TYPE";

    @BindView(R.id.itv_toolbar_back)
    IconTextView buttonBack;
    @BindView(R.id.tv_toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.rv_manage_tree)
    RecyclerView manageTree;

    private ManageTreeContractor.ManageTreePresenter mPresenter;
    private String manageType;


    public static void startActivity(Context context, String manageType) {
        Intent intent = new Intent(context, ManageTreeActivity.class);
        intent.putExtra(MANAGE_TYPE, manageType);
        context.startActivity(intent);
    }


    @Override
    protected int setLayoutRes() {
        return R.layout.activity_manage_tree;
    }

    @Override
    protected void initActivity() {
        setPresenter(new ManageTreePresenterImpl(this));
        initManageType();
        initClickListener();
        mPresenter.initManageList(manageTree);
    }

    private void initManageType() {
        manageType = getIntent().getStringExtra(MANAGE_TYPE);
        switch (manageType) {
            case ConfigUtil.PROJECT_MANAGE:
                toolbarTitle.setText("项目管理");
                break;
            case ConfigUtil.MEETING_MANAGE:
                toolbarTitle.setText("会议管理");
                break;
            case ConfigUtil.CUSTOMER_MANAGE:
                toolbarTitle.setText("客户管理");
                break;
            case ConfigUtil.FINANCE_MANAGE:
                toolbarTitle.setText("财务管理");
                break;
            case ConfigUtil.HR_MANAGE:
                toolbarTitle.setText("人事管理");
                break;
            case ConfigUtil.SUPPLYER_MANAGE:
                toolbarTitle.setText("供应商管理");
                break;
            case ConfigUtil.EQUIP_MANAGE:
                toolbarTitle.setText("设备管理");
                break;
            case ConfigUtil.DOCUMENT_MANAGE:
                toolbarTitle.setText("文档管理");
                break;
        }
        mPresenter.buildTreeData(manageType);
    }

    private void initClickListener() {
        buttonBack.setOnClickListener(this);
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
    public void setPresenter(ManageTreeContractor.ManageTreePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getActivityContext() {
        return activityContext;
    }
}
