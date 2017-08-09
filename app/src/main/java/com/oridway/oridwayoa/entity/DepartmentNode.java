package com.oridway.oridwayoa.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridwayoa.adapter.ContactExpandAdapter;

/**
 * Created by lihao on 2017/8/9.
 */

public class DepartmentNode extends AbstractExpandableItem<ContactNode> implements MultiItemEntity {

    public String departmentName;
    public String departmentOnline;

    public DepartmentNode(String departmentName, String departmentOnline) {
        this.departmentName = departmentName;
        this.departmentOnline = departmentOnline;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return ContactExpandAdapter.TYPE_PARENT;
    }
}
