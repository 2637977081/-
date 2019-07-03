//package com.univer.storage.controller;
//
//import com.univer.base.controller.BaseController;
//import com.univer.storage.po.SysLog;
//import com.univer.storage.service.LogService;
//import io.searchbox.client.JestResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @author lvgang
// * @descript
// * @time 2018-12-10 11:51
// */
//@RestController
//@RequestMapping("/log")
//public class LogController extends BaseController {
//
////    @Autowired
////    private LogService logService;
////
////    @PostMapping("/save/log")
////    public Object saveSysLog(@RequestBody SysLog sysLog){
////        JestResult jestResult = logService.saveSysLog(sysLog);
////        return resultVo.getInstance(HttpStatus.OK.toString(),jestResult.getJsonString());
////    }
////
////    @PostMapping("/save/log/list")
////    public Object saveLogList(List<SysLog> list){
////        JestResult jestResult = logService.saveLogList(list);
////        return resultVo.getInstance(HttpStatus.OK.toString(),jestResult.getJsonString());
////    }
////
////    @GetMapping("/delete/{id}")
////    public Object deleteById(@PathVariable("id")String id){
////        JestResult jestResult=logService.deleteById(id);
////        return resultVo.getInstance(HttpStatus.OK.toString(),jestResult.getJsonString());
////    }
////
////    @PostMapping("/update/log")
////    public Object updateById(SysLog sysLog){
////        JestResult jestResult = logService.updateLog(sysLog);
////        return resultVo.getInstance(HttpStatus.OK.toString(),jestResult.getJsonString());
////    }
////
////    @PostMapping("/search/log/list")
////    public Object searchLogList(@RequestBody SysLog sysLog){
////        if(sysLog.getPage()==null){
////            sysLog.setPage(Long.valueOf(0));
////        }
////        if(sysLog.getSize()==null){
////            sysLog.setSize(Long.valueOf(1000));
////        }
////        JestResult jestResult = logService.searchLogList(sysLog);
////        return resultVo.getInstance(HttpStatus.OK.toString(),jestResult.getJsonString());
////    }
////
////    @GetMapping("/detail/{id}")
////    public Object SearchLogById(@PathVariable("id") String id){
////        JestResult jestResult = logService.SearchLogById(id);
////        return resultVo.getInstance(HttpStatus.OK.toString(),jestResult.getJsonString());
////    }
//}
