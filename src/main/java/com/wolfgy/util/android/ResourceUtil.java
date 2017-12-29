package com.wolfgy.util.android;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ResourceUtil {

	/**
	 * 
	 * <p>
	 * Description:获取R文件中资源字段名<br />
	 * </p>
	 * @author wolfgy
	 * @version 0.1 2017年12月30日
	 * @param r 要进行反射的R文件
	 * @param resourceType 资源类型（如：drawable,string,mipmap...）
	 * @param value 要获取名字的字段的值
	 * @return
	 * String 资源字段名
	 */
    public static String getResourceFieldName(Class<?> r , String resourceType , int value){
        Class<?> resourceClass = r;
        Class<?>[] classes = resourceClass.getClasses();
        for (Class<?> c:
             classes) {
            int i = c.getModifiers();
            String className = c.getName();
            String s = Modifier.toString(i);
            if (s.contains("static") && className.contains(resourceType)) {
                Field[] fields = c.getFields();
                for (Field field:
                        fields) {
                    try {
                        if (field.getInt(field.getName()) == value){
                            return field.getName();
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }


    /**
     * 
     * <p>
     * Description:获取R文件中资源值<br />
     * </p>
     * @author wolfgy
     * @version 0.1 2017年12月30日
     * @param r 要进行反射的R文件
     * @param resourceType 资源类型（如：drawable,string,mipmap...）
     * @param name 资源字段名
     * @return
     * int 传入字段对应的值
     */
    public static int getResourceFieldValue(Class<?> r , String resourceType , String name){
        Class<?> resourceClass = r;
        Class<?>[] classes = resourceClass.getClasses();
        for (Class<?> c:
                classes) {
            int i = c.getModifiers();
            String className = c.getName();
            String s = Modifier.toString(i);
            if (s.contains("static") && className.contains(resourceType)) {
                Field[] fields = c.getFields();
                for (Field field:
                        fields) {
                    try {
                        if (field.getName().equals(name)){
                            return field.getInt(field.getName());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return -1;
    }
}
