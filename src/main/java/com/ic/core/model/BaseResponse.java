package com.ic.core.model;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * Description:
 * Author: CharlesSong
 * Date  : 2015/4/26
 */
public class BaseResponse {
    private String code = Code.SUCCESS;

    private String msg;

    private String transtime;

    public BaseResponse() {
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTranstime() {
        return transtime;
    }

    public void setTranstime(String transtime) {
        this.transtime = DateFormatUtils.format(new Date(), "yyyyMMdd hh:mm:ss:SSS");
    }
}
