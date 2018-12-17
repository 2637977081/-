package com.univer.storage.service;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-11 19:19
 */
@Service
public class FileService {

    private String ip = "192.168.152.128";
    private String userName = "lvgang";
    private String passWord = "123456";
    private String remoteDirectoryPath = "nginx/file";

    private Logger logger = LoggerFactory.getLogger(FileService.class);

    public String uploadFile(MultipartFile file){
        String name = null;
        FTPClient ftpClient = new FTPClient();
        try {

            String oldName = file.getOriginalFilename();
            String type = oldName.substring(oldName.lastIndexOf("."));
            String newName = UUID.randomUUID().toString().replaceAll("-","")+"."+type;
            InputStream input = file.getInputStream();

            ftpClient.connect(ip);
            boolean isLogin = ftpClient.login(userName, passWord);
            logger.info("uploadFile 登陆成功？ " + isLogin);
            ftpClient.setControlEncoding("UTF-8");
            //client告诉ftp server开通 一个端口来传输数据
            ftpClient.enterLocalPassiveMode();
            //设置文件类型
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.changeWorkingDirectory(remoteDirectoryPath);
            boolean isStore = ftpClient.storeFile(new String(newName.getBytes("UTF-8"),"iso-8859-1"), input);
            System.out.println("上传成功？ " + isStore);
            if(isStore){
                name = newName;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public boolean downloadFile(String name,String localFilePath){
        if(localFilePath.isEmpty()){
            localFilePath="D:\\";
        }
        boolean bool = true;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            boolean isLogin = ftpClient.login(userName, passWord);
            logger.info("uploadFile 登陆成功？ " + isLogin);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(remoteDirectoryPath);
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                if (file.getName().equals(name)) {
                    OutputStream output = new FileOutputStream(new File(localFilePath+"\\"+name));
                    ftpClient.retrieveFile(file.getName(), output);
                    output.flush();
                    output.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bool;
    }
}
