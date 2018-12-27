package com.univer.storage.controller;

import com.univer.base.controller.BaseController;
import com.univer.base.file.FTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-11 19:08
 */
@RestController
@RequestMapping("/file")
@Scope("prototype")
public class FileController extends BaseController {


    @PostMapping("/upload")
    public Object uploadFile(@RequestParam("file") MultipartFile file){
        String name = FTP.uploadFile(file);
        return resultVo.getInstance(HttpStatus.OK.toString(),name);
    }

    @GetMapping("/download")
    public Object downloadFile(String name,String localFilePath){
        //暂时有问题
        FTP.downloadFile(name,localFilePath);
        return resultVo.getInstance(HttpStatus.OK.toString());
    }
}
