package com.univer.course.enums;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 13:46
 */
public enum TeachTypeEnum {
    /**
     *required必修,elective选修
     */
    TEACHING("teaching"),TEACHED("teached"),LOSE("lose");
    private String teachType;

    /**
     * 校验 传入的 str 是否再枚举类型中存在
     * @param str str
     * @return
     */
    public static String getTeachTypeEnum(String str){
        for (TeachTypeEnum teachTypeEnum: TeachTypeEnum.values()) {
            if (teachTypeEnum.getTeachTypeEnum().equals(str)){
                return teachTypeEnum.teachType;
            }
        }
        return null;
    }

    public static Boolean isExisted(String str){
        for (TeachTypeEnum teachTypeEnum: TeachTypeEnum.values()) {
            if (teachTypeEnum.getTeachTypeEnum().equals(str)){
                return true;
            }
        }
        return false;
    }

    TeachTypeEnum(String teachType) {
        this.teachType = teachType;
    }

    public String getTeachTypeEnum() {
        return teachType;
    }

    public void setTeachTypeEnum(String teachType) {
        this.teachType = teachType;
    }

    @Override
    public String toString() {
        return teachType;
    }
}
