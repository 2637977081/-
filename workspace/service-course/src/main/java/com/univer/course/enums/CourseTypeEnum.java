package com.univer.course.enums;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 13:46
 */
public enum CourseTypeEnum {
    /**
     *required必修,elective选修
     */
    REQUIRED("required"),ELECTIVE("elective");
    private String courseType;

    /**
     * 校验 传入的 str 是否再枚举类型中存在
     * @param str str
     * @return
     */
    public static String getCourseTypeEnum(String str){
        for (CourseTypeEnum courseTypeEnum: CourseTypeEnum.values()) {
            if (courseTypeEnum.getCourseTypeEnum().equals(str)){
                return courseTypeEnum.courseType;
            }
        }
        return null;
    }

    public static Boolean isExisted(String str){
        for (CourseTypeEnum courseTypeEnum: CourseTypeEnum.values()) {
            if (courseTypeEnum.getCourseTypeEnum().equals(str)){
                return true;
            }
        }
        return false;
    }

    CourseTypeEnum(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseTypeEnum() {
        return courseType;
    }

    public void setCourseTypeEnum(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return courseType;
    }
}
