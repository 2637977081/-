package com.univer.base.param;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author guwei
 *
 * 基础参数
 */
public  class BaseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String callId;
    @NotEmpty
    private String reqTime;
    @NotEmpty
    private String signValue;

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getSignValue() {
        return signValue;
    }

    public void setSignValue(String signValue) {
        this.signValue = signValue;
    }

    public  void validate(){

    }


}
