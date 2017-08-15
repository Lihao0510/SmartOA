package com.oridway.oridwayoa.entity;

/**
 * Created by lihao on 2017/8/12.
 */

public class InnerMail {

    public int mailID;
    public int mailFrom;
    public int mailTo;
    public String senderName;
    public String senderEmail;
    public String senderDesc;
    public String mailTitle;
    public String mailContent;
    public String mailExtra;
    public int mailStatus;
    public int mailTag;
    public String mailDate;

    @Override
    public String toString() {
        return "InnerMail{" +
                "mailID=" + mailID +
                ", mailFrom=" + mailFrom +
                ", mailTo=" + mailTo +
                ", mailTitle='" + mailTitle + '\'' +
                ", mailContent='" + mailContent + '\'' +
                ", mailExtra='" + mailExtra + '\'' +
                ", mailStatus=" + mailStatus +
                ", mailTag=" + mailTag +
                '}';
    }

    public int getMailID() {
        return mailID;
    }

    public void setMailID(int mailID) {
        this.mailID = mailID;
    }

    public int getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(int mailFrom) {
        this.mailFrom = mailFrom;
    }

    public int getMailTo() {
        return mailTo;
    }

    public void setMailTo(int mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getMailExtra() {
        return mailExtra;
    }

    public void setMailExtra(String mailExtra) {
        this.mailExtra = mailExtra;
    }

    public int getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(int mailStatus) {
        this.mailStatus = mailStatus;
    }

    public int getMailTag() {
        return mailTag;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderDesc() {
        return senderDesc;
    }

    public void setSenderDesc(String senderDesc) {
        this.senderDesc = senderDesc;
    }

    public String getMailDate() {
        return mailDate;
    }

    public void setMailDate(String mailDate) {
        this.mailDate = mailDate;
    }

    public void setMailTag(int mailTag) {
        this.mailTag = mailTag;
    }
}
