package com.univer.base.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 日志
 * @author hongjiao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
@Scope("prototype")
public class SysLogBo {
    /**
     * 日志标题
     */
    private String logTitle;
    /**
     * 日志类型
     */
    private String logType;
    /**
     * 请求地址uri
     */
    private String requestUri;
    /**
     * 客户端IP
     */
    private String remoteAddr;
    /**
     * 请求地址url
     */
    private String serverAddr;
    /**
     * 类方法
     */
    private String classMethod;
    /**
     * 是否有异常
     */
    private boolean isException;
    /**
     * 异常信息
     */
    private String exceptionInfo;
    /**
     * 操作用户
     */
    private String operator;
    /**
     * 设备名称/操作系统
     */
    private String deviceName;
    /**
     * 浏览器名称
     */
    private String browserName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 执行时间
     */
    private Long executeTime;
    /**
     * 操作方式
     */
    private String requestMethod;
    /**
     * 入参
     */
    private String requestParams;
    /**
     * 出参
     */
    private String responseParams;

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getResponseParams() {
        return responseParams;
    }

    public void setResponseParams(String responseParams) {
        this.responseParams = responseParams;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public boolean isException() {
        return isException;
    }

    public void setException(boolean exception) {
        isException = exception;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }
}
