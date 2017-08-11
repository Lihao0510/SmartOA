package com.oridway.oridwayoa.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridcore.eventmessage.GlobalEvent;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.entity.ManageChildNode;
import com.oridway.oridwayoa.entity.ManageFatherNode;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lihao on 2017/8/11.
 */

public class ManageTreeAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_FATHER = 0;
    public static final int TYPE_CHILD = 1;

    public ManageTreeAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_FATHER, R.layout.item_manage_father);
        addItemType(TYPE_CHILD, R.layout.item_manage_child);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_FATHER:
                final ManageFatherNode fatherNode = (ManageFatherNode) item;
                helper.setText(R.id.tv_manage_title, fatherNode.kindName)
                        .setImageResource(R.id.iv_manage_lefticon, fatherNode.leftDrawableID)
                        .setText(R.id.itv_manage_right, fatherNode.isExpanded() ? "{fa-caret-down}" : "{fa-caret-right}");
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = helper.getAdapterPosition();
                        if (fatherNode.isExpanded()) {
                            collapse(position);
                        } else {
                            expand(position);
                            //TODO: 判定列表过长时,要手动将List上移
                        }
                    }
                });
                break;
            case TYPE_CHILD:
                final ManageChildNode childNode = (ManageChildNode) item;
                helper.setText(R.id.tv_manage_title, childNode.itemName)
                        .setImageResource(R.id.iv_manage_lefticon, childNode.leftDrawableID);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(childNode.itemName);

                    }
                });
                break;
        }
    }
}
