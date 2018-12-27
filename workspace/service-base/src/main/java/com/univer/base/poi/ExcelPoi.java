package com.univer.base.poi;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-12 15:10
 */
public class ExcelPoi {

    private Logger logger = LoggerFactory.getLogger(ExcelPoi.class);

    /**
     * 兼容excel2003 和excel2007
     * @param filePath
     * @return
     * @throws Exception
     */
    private Workbook getWriteWorkBoolType(String filePath,InputStream input) throws Exception{
        if (filePath.toLowerCase().endsWith("xlsx")) {
            return new XSSFWorkbook(input);
        } else if (filePath.toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook(input);
        } else {
            logger.error("excel格式文件错误");
        }
        return null;
    }

    private Workbook getWriteWorkBoolType(String filePath) throws Exception{
        if (filePath.toLowerCase().endsWith("xlsx")) {
            return new XSSFWorkbook();
        } else if (filePath.toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook();
        } else {
            logger.error("excel格式文件错误");
        }
        return null;
    }
    /**
     * 根据不同的参数类型读取
     * @param cell
     * @return
     */
    private Map<String, java.lang.Object> getCellStringVal(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object value = null;
        switch (cellType) {
            case NUMERIC:
                value=cell.getNumericCellValue();
                break;
            case STRING:
                value=cell.getStringCellValue();
                break;
            case BOOLEAN:
                value=String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                value=cell.getCellFormula();
                break;
            case BLANK:
                value="";
                break;
            case ERROR:
                value=String.valueOf(cell.getErrorCellValue());
                break;
            default:
                value= StringUtils.EMPTY;
        }
        Map<String, java.lang.Object> map = new HashMap<>(16);
        map.put("value",value);
        map.put("type",cellType);
        return map;
    }

    /**
     * 读取excel表
     * @param input
     * @param fileName
     * @return
     */
    public List<List<Map<String,Object>>> readExcel(InputStream input, String fileName){
        List<List<Map<String,Object>>> lists = new ArrayList<>();
        try {
            Workbook workbook = getWriteWorkBoolType(fileName,input);
            //读取第一个sheet页
            Sheet sheet = workbook.getSheetAt(0);
            for(int rowNum=0;rowNum<sheet.getLastRowNum()+1;rowNum++){
                List<Map<String,Object>> list = new ArrayList<>();
                Row row = sheet.getRow(rowNum);
                for(int cellNum=0;cellNum<row.getLastCellNum();cellNum++){
                    Cell cell = row.getCell(cellNum);
                    list.add(getCellStringVal(cell));
                }
                lists.add(list);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lists;
    }

    /**
     * 写excel表
     * @param lists
     * @param fileName
     * @return
     */
    public OutputStream writeExcel(List<List<Map<String, Object>>> lists, String fileName){
        OutputStream output = null;
        try {
            output = new FileOutputStream(new File(fileName));
            Workbook workbook = getWriteWorkBoolType(fileName);
            Sheet sheet = workbook.createSheet();
            for (int rowNum = 0;rowNum<lists.size();rowNum++){
                Row row = sheet.createRow(rowNum);
                List<Map<String,Object>> list = lists.get(rowNum);
                for(int cellNum=0;cellNum<list.size();cellNum++){
                    Cell cell = row.createCell(cellNum);
                    cell.setCellValue(list.get(cellNum).get("value").toString());
                    cell.setCellType((CellType)list.get(cellNum).get("type"));
                }
            }
            workbook.write(output);
            output.flush();
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return output;
    }

    public static void main(String[] args){
        List<List<Map<String,Object>>> lists = new ArrayList<>();
        try {
            ExcelPoi excelPoi = new ExcelPoi();
            File file = new File("C:\\Users\\univer\\Desktop\\test.xlsx");
            InputStream input =new FileInputStream(file);
            lists=excelPoi.readExcel(input,file.getName());
            System.out.println(lists.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            ExcelPoi excelPoi = new ExcelPoi();
            String fileName = "C:\\Users\\univer\\Desktop\\test2.xlsx";
            excelPoi.writeExcel(lists,fileName);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
