package com.oridway.oridwayoa.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridcore.utils.ConfigUtil;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.adapter.ManageTreeAdapter;
import com.oridway.oridwayoa.contract.ManageTreeContract;
import com.oridway.oridwayoa.entity.ManageChildNode;
import com.oridway.oridwayoa.entity.ManageFatherNode;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/11.
 */

public class ManageTreePresenterImpl implements ManageTreeContract.ManageTreePresenter {

    private ManageTreeContract.ManageTreeView mView;
    private LinearLayoutManager layoutManager;
    private ManageTreeAdapter mAdapter;
    private List<MultiItemEntity> treeItemList;

    public ManageTreePresenterImpl(ManageTreeContract.ManageTreeView view) {
        this.mView = view;
        init();
    }

    @Override
    public void init() {
        treeItemList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(mView.getActivityContext(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public void initManageList(RecyclerView manageList) {
        mAdapter = new ManageTreeAdapter(treeItemList);
        manageList.setAdapter(mAdapter);
        manageList.setLayoutManager(layoutManager);
        OverScrollDecoratorHelper.setUpOverScroll(manageList, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }

    @Override
    public void buildTreeData(String treeType) {
        treeItemList.clear();
        switch (treeType) {
            case ConfigUtil.PROJECT_MANAGE:
                ManageFatherNode projectF1 = new ManageFatherNode("发起中项目", R.drawable.project_one);
                ManageFatherNode projectF2 = new ManageFatherNode("进行中项目", R.drawable.project_two);
                ManageFatherNode projectF3 = new ManageFatherNode("完工项目", R.drawable.project_three);
                ManageChildNode projectC1 = new ManageChildNode("新建项目一览表", R.drawable.project_four, true);
                ManageChildNode projectC2 = new ManageChildNode("发起新项目", R.drawable.project_four, true);
                ManageChildNode projectC3 = new ManageChildNode("在线项目一览表", R.drawable.project_four, true);
                ManageChildNode projectC4 = new ManageChildNode("在线项目进度", R.drawable.project_four, true);
                ManageChildNode projectC5 = new ManageChildNode("项目合同记录", R.drawable.project_four, true);
                ManageChildNode projectC6 = new ManageChildNode("项目付款记录", R.drawable.project_four, true);
                ManageChildNode projectC7 = new ManageChildNode("完工项目一览表", R.drawable.project_four, true);
                ManageChildNode projectC8 = new ManageChildNode("完工项目账款", R.drawable.project_four, true);
                projectF1.addSubItem(projectC1);
                projectF1.addSubItem(projectC2);
                projectF2.addSubItem(projectC3);
                projectF2.addSubItem(projectC4);
                projectF2.addSubItem(projectC5);
                projectF2.addSubItem(projectC6);
                projectF3.addSubItem(projectC7);
                projectF3.addSubItem(projectC8);
                treeItemList.add(projectF1);
                treeItemList.add(projectF2);
                treeItemList.add(projectF3);
                break;
            case ConfigUtil.MEETING_MANAGE:
                break;
            case ConfigUtil.CUSTOMER_MANAGE:
                ManageFatherNode customerF1 = new ManageFatherNode("客户资料", R.drawable.customer_contact);
                ManageFatherNode customerF2 = new ManageFatherNode("客户联系人", R.drawable.customer_info);
                ManageFatherNode customerF3 = new ManageFatherNode("客户账款", R.drawable.customer_line);
                ManageChildNode customerC1 = new ManageChildNode("客户资料一览表", R.drawable.customer_contact, true);
                ManageChildNode customerC2 = new ManageChildNode("客户项目一览表", R.drawable.customer_pay, true);
                ManageChildNode customerC21 = new ManageChildNode("潜在客户一览表", R.drawable.customer_pay, true);
                ManageChildNode customerC3 = new ManageChildNode("客户联系人一览表", R.drawable.customer_single, true);
                ManageChildNode customerC4 = new ManageChildNode("客户项目负责人", R.drawable.customer_staff, true);
                ManageChildNode customerC5 = new ManageChildNode("客户账目查询", R.drawable.customer_line, true);
                ManageChildNode customerC6 = new ManageChildNode("客户回款查询", R.drawable.customer_info, true);
                ManageChildNode customerC7 = new ManageChildNode("客户欠款查询", R.drawable.customer_staff, true);
                ManageChildNode customerC8 = new ManageChildNode("客户坏账查询", R.drawable.customer_contact, true);
                customerF1.addSubItem(customerC1);
                customerF1.addSubItem(customerC2);
                customerF2.addSubItem(customerC3);
                customerF2.addSubItem(customerC4);
                customerF3.addSubItem(customerC5);
                customerF3.addSubItem(customerC6);
                customerF3.addSubItem(customerC7);
                customerF3.addSubItem(customerC8);
                treeItemList.add(customerF1);
                treeItemList.add(customerF2);
                treeItemList.add(customerF3);
                break;
            case ConfigUtil.FINANCE_MANAGE:
                break;
            case ConfigUtil.HR_MANAGE:
                break;
            case ConfigUtil.SUPPLYER_MANAGE:
                break;
            case ConfigUtil.EQUIP_MANAGE:
                break;
            case ConfigUtil.DOCUMENT_MANAGE:
                break;
        }
    }
}
