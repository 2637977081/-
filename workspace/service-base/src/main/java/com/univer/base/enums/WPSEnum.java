package com.univer.base.enums;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-28 20:44
 */
public enum WPSEnum {
    DOC("doc"),DOCX("docx"),XLS("xls"),XLSX("xlsx"),PPT("ppt"),PPTX("pptx");
    private String wps;

    WPSEnum(String wps){this.wps=wps;}

    @Override
    public String toString() {
        return wps;
    }

    public static String getWPS(String str){
        for (WPSEnum se: WPSEnum.values()) {
            if (se.getWPS().equals(str)){
                return se.wps;
            }
        }
        return null;
    }

    public String getWPS() {
        return wps;
    }

    public void setWPS(String wps) {
        this.wps = wps;
    }

}
