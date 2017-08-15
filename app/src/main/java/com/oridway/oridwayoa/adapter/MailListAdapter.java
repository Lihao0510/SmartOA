package com.oridway.oridwayoa.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.entity.InnerMail;

import java.util.List;

/**
 * Created by lihao on 2017/8/12.
 */

public class MailListAdapter extends BaseQuickAdapter<InnerMail, BaseViewHolder> {
    public MailListAdapter(@Nullable List<InnerMail> data) {
        super(R.layout.item_inner_mail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final InnerMail item) {
        helper.setText(R.id.tv_mail_lefticon, item.senderName.substring(0, 1))
                .setText(R.id.tv_mail_sender, item.senderName)
                .setText(R.id.tv_mail_title, item.mailTitle)
                .setText(R.id.tv_mail_content, item.mailContent)
                .setText(R.id.tv_mail_isnew, item.mailStatus == 0 ? "新邮件!" : "");
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(item.mailTitle);
            }
        });
    }
}
