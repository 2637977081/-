package com.univer.storage.controller;

import com.univer.base.controller.BaseController;
import com.univer.storage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-11 19:08
 */
@RestController
@RequestMapping("/file")
@Scope("prototype")
public class FileController extends BaseController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Object uploadFile(@RequestParam("file") MultipartFile file){
        String name= fileService.uploadFile(file);
        return resultVo.getInstance(HttpStatus.OK.toString(),name);
    }

    @GetMapping("/download/{name}")
    public Object downloadFile(@PathVariable("name") String name,String localFilePath){
        fileService.downloadFile(name,localFilePath);
        return resultVo.getInstance(HttpStatus.OK.toString());
    }
}
