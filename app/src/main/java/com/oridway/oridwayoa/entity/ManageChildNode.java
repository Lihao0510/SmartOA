package com.oridway.oridwayoa.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridwayoa.adapter.ManageTreeAdapter;

/**
 * Created by lihao on 2017/8/11.
 */

public class ManageChildNode implements MultiItemEntity {

    public String itemName;
    public int leftDrawableID;
    public boolean canUse;

    public ManageChildNode(String itemName, int leftDrawableID, boolean canUse) {
        this.itemName = itemName;
        this.leftDrawableID = leftDrawableID;
        this.canUse = canUse;
    }

    @Override
    public int getItemType() {
        return ManageTreeAdapter.TYPE_CHILD;
    }
}
