package com.univer.storage.controller;

import com.univer.base.controller.BaseController;
import com.univer.base.enums.ImageEnum;
import com.univer.base.enums.WPSEnum;
import com.univer.base.file.FTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

    private String savePath="D:\\graduation\\files";

    @PostMapping("/upload")
    public Object uploadFile(@RequestParam("file") MultipartFile file){
        String name = FTP.uploadFile(file);
        return resultVo.getInstance(HttpStatus.OK.toString(),name);
    }

    @PostMapping("/save")
    public Object saveFile(@RequestParam("file") MultipartFile file){
        String oldName = file.getOriginalFilename();
        String type = oldName.substring(oldName.lastIndexOf(".")+1);
        String newName = UUID.randomUUID().toString().replaceAll("-","")+"."+type;
        InputStream input = null;
        OutputStream output = null;
        try {
            String saveFile = "";
            if(ImageEnum.getImage(type)!=null){
                saveFile = savePath+"\\images\\"+newName;
            }else if(WPSEnum.getWPS(type)!=null){
                saveFile = savePath+"\\wps\\"+newName;
            }else {
                saveFile = savePath+"\\others\\"+newName;
            }
            input = file.getInputStream();
            output = new FileOutputStream(saveFile);
            byte[] bytes = new byte[1024];
            int len;
            while ((len=input.read(bytes))!=-1){
                output.write(bytes,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                output.close();
                input.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultVo.getInstance(HttpStatus.OK.toString(),newName);
    }

    @GetMapping("/download")
    public Object downloadFile(String name,String localFilePath){
        //暂时有问题
        FTP.downloadFile(name,localFilePath);
        return resultVo.getInstance(HttpStatus.OK.toString());
    }
}
