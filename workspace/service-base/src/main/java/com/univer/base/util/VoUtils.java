package com.univer.base.util;

import java.lang.reflect.Field;

/**
 * @author guwei
 */
public class VoUtils {

    /**
     * 指定属性复制
     */
    public static void copyProperties(Object source, Object target,String... properties) throws IllegalAccessException {
        for (String property: properties) {
            Field field = getField(source.getClass(), property);
            if(field != null) {
                field.setAccessible(true);
                field.set(target,field.get(source));
            }
        }
    }

    /**
     * 迭代查找Field
     */
    public static Field getField(Class clazz, String property) {
        Field field = null;
        Field[] fields = clazz.getDeclaredFields();
        for (Field temp: fields) {
            if(property.equals(temp.getName())) {
                field = temp;
                break;
            }
        }
        if(field == null && clazz.getSuperclass() != null) {
            field = getField(clazz.getSuperclass(), property);
        }
        return field;
    }
}
