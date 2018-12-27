package com.univer.base.enums;

/**
 * 状态枚举类
 * @author hongjiao
 */
public enum StatusEnum {
    /**
     * 已删除、可用、禁用
     */
    DELETED("deleted"),ENABLED("enabled"),DISABLED("disabled");
    private String status;

    StatusEnum(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

    public static String getStatus(String str){
        for (StatusEnum se: StatusEnum.values()) {
            if (se.getStatus().equals(str)){
                return se.status;
            }
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
