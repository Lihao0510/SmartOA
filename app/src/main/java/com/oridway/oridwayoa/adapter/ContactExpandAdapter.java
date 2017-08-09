package com.oridway.oridwayoa.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridcore.eventmessage.GlobalEvent;
import com.oridway.oridcore.utils.ToastUtil;
import com.oridway.oridcore.widge.CircleHeadView;
import com.oridway.oridwayoa.R;
import com.oridway.oridwayoa.entity.ContactNode;
import com.oridway.oridwayoa.entity.DepartmentNode;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lihao on 2017/8/9.
 */

public class ContactExpandAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_PARENT = 0;
    public static final int TYPE_CHILD = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ContactExpandAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_PARENT, R.layout.item_contact_department);
        addItemType(TYPE_CHILD, R.layout.item_contact_person);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_PARENT:
                final DepartmentNode departmentNode = (DepartmentNode) item;
                helper.setText(R.id.tv_department_name, departmentNode.departmentName)
                        .setText(R.id.tv_department_online, departmentNode.departmentOnline)
                        .setText(R.id.itv_department_logo, departmentNode.isExpanded() ? "{fa-caret-down}" : "{fa-caret-right}");
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = helper.getAdapterPosition();
                        if (departmentNode.isExpanded()) {
                            collapse(position);
                        } else {
                            expand(position);
                            GlobalEvent event = GlobalEvent.newEvent(GlobalEvent.CONTACT_WILL_EXPAND);
                            int size = departmentNode.getSubItems().size();
                            if (size > 4) {
                                size = 4;
                            }
                            event.setEventBody(size + position);
                            EventBus.getDefault().post(event);
                        }
                    }
                });
                break;
            case TYPE_CHILD:
                final ContactNode contactNode = (ContactNode) item;
                helper.setText(R.id.tv_contact_name, contactNode.contactName)
                        .setText(R.id.tv_contact_sign, contactNode.contactSign);
                ((CircleHeadView) helper.itemView.findViewById(R.id.chv_contact_head)).setNameText(contactNode.contactName, contactNode.contactStatus);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(contactNode.contactName);
                    }
                });
                break;
        }
    }
}
