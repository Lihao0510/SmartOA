package com.oridway.oridwayoa.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by lihao on 2017/8/9.
 */

public class ContactAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ContactAdapter(List<MultiItemEntity> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {

    }
}
