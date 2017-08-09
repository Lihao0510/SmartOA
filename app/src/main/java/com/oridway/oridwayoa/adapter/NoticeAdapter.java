package com.oridway.oridwayoa.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.entity.EnterpriseNotice;

import java.util.List;

/**
 * Created by lihao on 2017/8/7.
 */

public class NoticeAdapter extends BaseQuickAdapter<EnterpriseNotice, BaseViewHolder> {

    public NoticeAdapter(@Nullable List<EnterpriseNotice> data) {
        super(R.layout.item_notice, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EnterpriseNotice item) {
        helper.setText(R.id.tv_notice_title, item.getNoticeTitle())
                .setText(R.id.tv_notice_content, item.getNoticeContent())
                .setText(R.id.tv_notice_author, item.getNoticeAuthor())
                .setText(R.id.tv_notice_date, item.getNoticeDate().substring(0, 10));
    }
}
