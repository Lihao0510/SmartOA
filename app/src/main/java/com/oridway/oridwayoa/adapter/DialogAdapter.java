package com.oridway.oridwayoa.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.oridway.oridcore.widge.CircleHeadView;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.entity.HistoryDialog;

import java.util.List;

/**
 * Created by lihao on 2017/8/9.
 */

public class DialogAdapter extends BaseQuickAdapter<HistoryDialog, BaseViewHolder> {

    public DialogAdapter(@Nullable List<HistoryDialog> data) {
        super(R.layout.item_talk_dialog, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HistoryDialog item) {
        helper.setText(R.id.tv_dialog_name, item.userName)
                .setText(R.id.tv_dialog_content, item.lastSnapshot)
                .setText(R.id.tv_dialog_time, item.lastTime);
        ((CircleHeadView) helper.itemView.findViewById(R.id.chv_dialog_head)).setNameText(item.userName, 1);
    }
}
