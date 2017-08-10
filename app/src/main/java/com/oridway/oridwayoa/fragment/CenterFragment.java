package com.oridway.oridwayoa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.joanzapata.iconify.widget.IconTextView;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridwayoa.R;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by lihao on 2017/8/5.
 */

public class CenterFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.sv_center_container)
    ScrollView centerContainer;
    @BindView(R.id.civ_center_head)
    CircleImageView headView;
    @BindView(R.id.tv_center_name)
    TextView userName;
    @BindView(R.id.tv_center_career)
    TextView userCareer;
    @BindView(R.id.tv_center_department)
    TextView userDepartment;
    @BindView(R.id.ll_center_mymessage)
    LinearLayout mymessageButton;
    @BindView(R.id.ll_center_backlog)
    LinearLayout backlogButton;
    @BindView(R.id.ll_center_myproject)
    LinearLayout myprojectButton;
    @BindView(R.id.ll_center_myapply)
    LinearLayout myapplyButton;
    @BindView(R.id.ll_center_clockin)
    LinearLayout clockinButton;
    @BindView(R.id.ll_center_travel)
    LinearLayout travelButton;
    @BindView(R.id.ll_center_diary)
    LinearLayout textButton;
    @BindView(R.id.ll_center_notice)
    LinearLayout noticeButton;
    @BindView(R.id.ll_center_mydepartment)
    LinearLayout departmentButton;
    @BindView(R.id.itv_center_setting)
    IconTextView settingIcon;
    @BindView(R.id.itv_center_quit)
    IconTextView quitLoginIcon;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_center, container, false);

    }

    @Override
    protected void initFragment() {
        OverScrollDecoratorHelper.setUpOverScroll(centerContainer);
        initUserMessage();
        initClickListener();
    }

    private void initClickListener() {
        backlogButton.setOnClickListener(this);
        myprojectButton.setOnClickListener(this);
        myapplyButton.setOnClickListener(this);
        clockinButton.setOnClickListener(this);
        travelButton.setOnClickListener(this);
        textButton.setOnClickListener(this);
        noticeButton.setOnClickListener(this);
        departmentButton.setOnClickListener(this);
        mymessageButton.setOnClickListener(this);
        settingIcon.setOnClickListener(this);
        quitLoginIcon.setOnClickListener(this);

    }

    private void initUserMessage() {
        userName.setText("王倪金");
        userDepartment.setText("系统开发部");
        userCareer.setText("副部长 高级工程师");
        Glide.with(getContext()).load("https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/TB1kqNYRVXXXXcyXVXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg").into(headView);

    }

    @Override
    public void onClick(View v) {
        ToastUtil.showToast("" + v.getId());
        switch (v.getId()) {
            case R.id.ll_center_backlog:

                break;
            case R.id.ll_center_myproject:

                break;
            case R.id.ll_center_myapply:

                break;
            case R.id.ll_center_clockin:

                break;
            case R.id.ll_center_diary:

                break;
            case R.id.ll_center_travel:

                break;
            case R.id.ll_center_mydepartment:

                break;
            case R.id.ll_center_notice:

                break;
            case R.id.ll_center_mymessage:

                break;
            case R.id.itv_center_quit:

                break;
            case R.id.itv_center_setting:

                break;
            default:
                break;
        }
    }
}
