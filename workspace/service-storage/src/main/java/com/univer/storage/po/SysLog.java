//package com.univer.storage.po;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.univer.base.bo.SysLogBo;
//import org.springframework.context.annotation.Scope;
//import org.springframework.data.annotation.Id;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//
//
///**
// * @descrption:
// * @author: lvgang
// * @date: 2018-10-23 10:15
// **/
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Component
//@Scope("prototype")
//public class SysLog extends SysLogBo implements Serializable {
//
//    public static final String INDEX = "service_log";
//    public static final String TYPE = "controller";
//
//    @Id
//    private String id;
//
//    private Long orderTime;
//
//    private Long page;
//
//    private Long size;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Long getOrderTime() {
//        return orderTime;
//    }
//
//    public void setOrderTime(Long orderTime) {
//        this.orderTime = orderTime;
//    }
//
//    public Long getPage() {
//        return page;
//    }
//
//    public void setPage(Long page) {
//        this.page = page;
//    }
//
//    public Long getSize() {
//        return size;
//    }
//
//    public void setSize(Long size) {
//        this.size = size;
//    }
//}
