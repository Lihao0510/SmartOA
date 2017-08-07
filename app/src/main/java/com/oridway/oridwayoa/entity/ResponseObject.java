package com.oridway.oridwayoa.entity;

/**
 * Created by lihao on 2017/8/4.
 */

public class ResponseObject<T> {

    public int status;
    public String errorMsg = "";
    public T result;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "status=" + status +
                ", result=" + result.toString() +
                '}';
    }
}
