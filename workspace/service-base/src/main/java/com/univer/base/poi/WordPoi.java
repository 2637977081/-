package com.univer.base.poi;


import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-12 17:03
 */
public class WordPoi {

    private Logger logger = LoggerFactory.getLogger(WordPoi.class);

    public String readWord(InputStream input,String name) {
        String buffer = "";
        try {
            if (name.toLowerCase().endsWith(".doc")) {
                WordExtractor extractor = new WordExtractor(input);
                buffer = extractor.getText();
                extractor.close();
            } else if (name.toLowerCase().endsWith("docx")) {
                XWPFDocument docx = new XWPFDocument(input);
                XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
                buffer = extractor.getText();
                extractor.close();
            } else {
                logger.error("excel格式文件错误");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }

    public static void main(String[] args){
        try {
            WordPoi wordPoi = new WordPoi();
            File file = new File("C:\\Users\\univer\\Desktop\\毕业生实习任务附件\\附件1：社会需求调查表.docx");
            InputStream input = new FileInputStream(file);
            String name= file.getName();
            String buffer = wordPoi.readWord(input,name);
            System.out.println(buffer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
