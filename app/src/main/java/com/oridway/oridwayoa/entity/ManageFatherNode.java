package com.oridway.oridwayoa.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridwayoa.adapter.ManageTreeAdapter;

/**
 * Created by lihao on 2017/8/11.
 */

public class ManageFatherNode extends AbstractExpandableItem<ManageChildNode> implements MultiItemEntity {

    public String kindName;
    public int leftDrawableID;

    public ManageFatherNode(String kindName, int leftDrawableID) {
        this.kindName = kindName;
        this.leftDrawableID = leftDrawableID;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return ManageTreeAdapter.TYPE_FATHER;
    }
}
