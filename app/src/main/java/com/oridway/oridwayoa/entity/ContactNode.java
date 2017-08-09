package com.oridway.oridwayoa.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oridway.oridwayoa.adapter.ContactExpandAdapter;

/**
 * Created by lihao on 2017/8/9.
 */

public class ContactNode implements MultiItemEntity {

    public String contactName;
    public String contactSign;
    public int contactID;
    public int contactStatus;

    public ContactNode(String contactName, String contactSign, int contactID, int contactStatus) {
        this.contactName = contactName;
        this.contactSign = contactSign;
        this.contactID = contactID;
        this.contactStatus = contactStatus;
    }

    @Override
    public int getItemType() {
        return ContactExpandAdapter.TYPE_CHILD;
    }
}
