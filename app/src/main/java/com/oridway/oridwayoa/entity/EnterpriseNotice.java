package com.oridway.oridwayoa.entity;

import java.io.Serializable;

/**
 * Created by lihao on 2017/8/7.
 */

public class EnterpriseNotice implements Serializable {

    public int noticeID;
    public int noticeType;
    public String noticeDate;
    public String noticeTitle;
    public String noticeAuthor;
    public String noticeContent;
    public String noticePicUrl;

    public int getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(int noticeID) {
        this.noticeID = noticeID;
    }

    public int getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(int noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeAuthor() {
        return noticeAuthor;
    }

    public void setNoticeAuthor(String noticeAuthor) {
        this.noticeAuthor = noticeAuthor;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticePicUrl() {
        return noticePicUrl;
    }

    public void setNoticePicUrl(String noticePicUrl) {
        this.noticePicUrl = noticePicUrl;
    }

    @Override
    public String toString() {
        return "EnterpriseNotice{" +
                "noticeID=" + noticeID +
                ", noticeType=" + noticeType +
                ", noticeDate='" + noticeDate + '\'' +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeAuthor='" + noticeAuthor + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticePicUrl='" + noticePicUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnterpriseNotice that = (EnterpriseNotice) o;

        if (noticeID != that.noticeID) return false;
        if (noticeType != that.noticeType) return false;
        if (noticeDate != null ? !noticeDate.equals(that.noticeDate) : that.noticeDate != null)
            return false;
        if (noticeTitle != null ? !noticeTitle.equals(that.noticeTitle) : that.noticeTitle != null)
            return false;
        if (noticeAuthor != null ? !noticeAuthor.equals(that.noticeAuthor) : that.noticeAuthor != null)
            return false;
        if (noticeContent != null ? !noticeContent.equals(that.noticeContent) : that.noticeContent != null)
            return false;
        return noticePicUrl != null ? noticePicUrl.equals(that.noticePicUrl) : that.noticePicUrl == null;

    }

    @Override
    public int hashCode() {
        int result = noticeID;
        result = 31 * result + noticeType;
        result = 31 * result + (noticeDate != null ? noticeDate.hashCode() : 0);
        result = 31 * result + (noticeTitle != null ? noticeTitle.hashCode() : 0);
        result = 31 * result + (noticeAuthor != null ? noticeAuthor.hashCode() : 0);
        result = 31 * result + (noticeContent != null ? noticeContent.hashCode() : 0);
        result = 31 * result + (noticePicUrl != null ? noticePicUrl.hashCode() : 0);
        return result;
    }
}
