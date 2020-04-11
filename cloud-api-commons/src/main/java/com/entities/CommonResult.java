package com.entities;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {

    private String errCode;
    private String errMsg;
    private T data;


    public CommonResult() {
    }

    public CommonResult(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonResult(String errCode, String errMsg, T data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("errCode", errCode)
                .add("errMsg", errMsg)
                .add("data", data)
                .toString();
    }
}
