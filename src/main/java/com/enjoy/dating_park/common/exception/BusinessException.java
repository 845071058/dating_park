package com.enjoy.dating_park.common.exception;

/**
 * @author sean.Wan
 * @version 0.1
 * @date 2020/4/1 16:41
 */
public class BusinessException extends Exception {

    private int errCode;
    private String errMsg;

    public BusinessException() {
    }

    public BusinessException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}