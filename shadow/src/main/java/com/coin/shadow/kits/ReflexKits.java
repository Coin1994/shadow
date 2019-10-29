package com.coin.shadow.kits;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 13:31
 * @description：java 反射小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class ReflexKits {
    /***
     * 禁止外部初始化
     */
    private ReflexKits(){
    }

    /***
     * @param list
     * @param clz
     * @param ignore
     * @return
     */
    public static List<Field> getFields(List<Field> list, Class<?> clz, boolean ignore){
        list = CollectionsKits.isEmpty(list) ? Lists.newArrayList() : list;
        list.addAll(Arrays.asList(clz.getDeclaredFields()));
        return ignore ? list : getFields(list, clz.getSuperclass(), true);
    }

    /***
     * @param map
     * @param clz
     * @param ignore
     * @return
     */
    public static Map<String, Object> getFields(Map<String, Object> map, Class<?> clz, boolean ignore){
        map = CollectionsKits.isEmpty(map) ? Maps.newHashMap() : map;
        
        return null;
    }

    public static boolean isInterface(Class<?> clz){
        return clz != null && clz.isInterface();
    }

    public static boolean isAnnotation(Class<?> clz){
        return clz != null && clz.isAnnotation();
    }

    public static boolean isEnum(Class<?> clz){
        return clz != null && clz.isEnum();
    }
}
