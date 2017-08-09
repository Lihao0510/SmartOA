package com.oridway.oridwayoa.presenter;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridcore.eventmessage.GlobalEvent;
import com.oridway.oridcore.utils.LogUtil;
import com.oridway.oridwayoa.adapter.ContactExpandAdapter;
import com.oridway.oridwayoa.adapter.DialogAdapter;
import com.oridway.oridwayoa.contract.TalkFragmentContractor;
import com.oridway.oridwayoa.entity.ContactNode;
import com.oridway.oridwayoa.entity.DepartmentNode;
import com.oridway.oridwayoa.entity.HistoryDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/9.
 */

public class TalkFragmentPresenterImpl implements TalkFragmentContractor.TalkFragmentPresenter {

    private TalkFragmentContractor.TalkFragmentView mView;
    private LinearLayoutManager dialogLayoutManager;
    private LinearLayoutManager contactLayoutManager;
    private List<MultiItemEntity> departmentList;
    private List<HistoryDialog> dialogList;
    private ContactExpandAdapter contactAdapter;

    public TalkFragmentPresenterImpl(TalkFragmentContractor.TalkFragmentView view) {
        mView = view;
        init();
    }

    @Override
    public void init() {
        dialogLayoutManager = new LinearLayoutManager(mView.getActivityContext());
        contactLayoutManager = new LinearLayoutManager(mView.getActivityContext());
        departmentList = new ArrayList<>();
        dialogList = new ArrayList<>();
    }

    @Override
    public void initDialogList(RecyclerView dialogListView) {
        getDialogList();
        DialogAdapter dialogAdapter = new DialogAdapter(dialogList);
        dialogListView.setLayoutManager(dialogLayoutManager);
        dialogListView.setAdapter(dialogAdapter);
        OverScrollDecoratorHelper.setUpOverScroll(dialogListView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);

    }

    @Override
    public void initContactList(RecyclerView contactListView) {
        getContactList();
        contactAdapter = new ContactExpandAdapter(departmentList);
        contactListView.setAdapter(contactAdapter);
        contactListView.setLayoutManager(contactLayoutManager);
        OverScrollDecoratorHelper.setUpOverScroll(contactListView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }

    private void getDialogList() {
        HistoryDialog dialog1 = new HistoryDialog("行政小助手^_^", "18:51", "班车时刻表最新版已经发到各位的邮箱里啦!");
        HistoryDialog dialog2 = new HistoryDialog("IT服务台", "昨天", "您的调休申请已经通过!");
        HistoryDialog dialog3 = new HistoryDialog("王尼玛", "星期三", "晚上撸不撸两把 [图片]");
        dialogList.add(dialog1);
        dialogList.add(dialog2);
        dialogList.add(dialog3);
    }

    private void getContactList() {
        DepartmentNode node1 = new DepartmentNode("行政部", "1/5");
        ContactNode contact1 = new ContactNode("王妮金", "大家好,我是新员工王尼玛!", 10000, 1);
        ContactNode contact2 = new ContactNode("赵尼玛", "大家好,我是新员工王尼玛!", 10001, 0);
        ContactNode contact3 = new ContactNode("成倪金", "大家好,我是新员工王尼玛!", 10002, 0);
        ContactNode contact4 = new ContactNode("李妮金", "大家好,我是新员工王尼玛!", 10003, 0);
        ContactNode contact5 = new ContactNode("周妮金", "大家好,我是新员工王尼玛!", 10004, 0);
        node1.addSubItem(contact1);
        node1.addSubItem(contact2);
        node1.addSubItem(contact3);
        node1.addSubItem(contact4);
        node1.addSubItem(contact5);
        DepartmentNode node2 = new DepartmentNode("测试部", "3/4");
        ContactNode contact6 = new ContactNode("王妮金", "大家好,我是新员工王尼玛!", 10005, 1);
        ContactNode contact7 = new ContactNode("贺妮金", "大家好,我是新员工王尼玛!", 10006, 1);
        ContactNode contact8 = new ContactNode("王妮金", "大家好,我是新员工王尼玛!", 10007, 1);
        ContactNode contact9 = new ContactNode("孙妮金", "大家好,我是新员工王尼玛!", 10008, 0);
        node2.addSubItem(contact6);
        node2.addSubItem(contact7);
        node2.addSubItem(contact8);
        node2.addSubItem(contact9);
        DepartmentNode node3 = new DepartmentNode("总经办", "2/4");
        ContactNode contact10 = new ContactNode("王妮金", "大家好,我是新员工王尼玛!", 10009, 1);
        ContactNode contact11 = new ContactNode("正妮金", "大家好,我是新员工王尼玛!", 10010, 1);
        ContactNode contact12 = new ContactNode("吊妮金", "大家好,我是新员工王尼玛!", 10011, 0);
        ContactNode contact13 = new ContactNode("莫妮金", "大家好,我是新员工王尼玛!", 10012, 0);
        node3.addSubItem(contact10);
        node3.addSubItem(contact11);
        node3.addSubItem(contact12);
        node3.addSubItem(contact13);
        departmentList.add(node1);
        departmentList.add(node3);
        departmentList.add(node2);
    }


}
