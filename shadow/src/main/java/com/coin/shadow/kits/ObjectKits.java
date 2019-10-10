package com.coin.shadow.kits;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/10 9:32
 * @description：对象处理小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class ObjectKits {

    /***
     * 禁止外部初始化
     */
    private ObjectKits(){
    }

    public static boolean isNull(Object object){
        return object == null;
    }

    public static boolean isNotNull(Object object){
        return !isNull(object);
    }

    public static List<Field> getFields(List<Field> list, Class<?> clz, boolean ignore){
        list = CollectionsKits.isEmpty(list) ? Lists.newArrayList() : list;
        list.addAll(Arrays.asList(clz.getDeclaredFields()));
        return ignore ? list : getFields(list, clz.getSuperclass(), true);
    }
    /***
     * 对象转map
     * @param object
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object object){
        if (isNull(object)){
            return CollectionsKits.emptyMap();
        }
        try {
            Map<String, Object> map = Maps.newHashMap();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(object));
            }
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }
        return CollectionsKits.emptyMap();
    }


    /**
     * map 转对象
     * @param map
     * @param cls
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> cls) throws Exception{
        Object object = cls.newInstance();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for(Field field:declaredFields){
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }
            field.setAccessible(true);
            field.set(object, map.get(field.getName()));
        }
        return object;
    }

    public static final <Left, Right> Right clone (Left leftValue, Right rightValue, boolean ignore){
        List<Field> leftFields = getFields(null, leftValue.getClass(), ignore);
        if (CollectionsKits.isEmpty(leftFields)){
            return null;
        }
        List<Field> rightFields = getFields(null, rightValue.getClass(),ignore);
        if (CollectionsKits.isEmpty(rightFields)){
            return null;
        }
        Map<String, Object> map = Maps.newHashMap();
        try {
            for (Field field: leftFields) {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                field.setAccessible(true);
                Object o = field.get(leftValue);
                if (isNotNull(o)){
                    map.put(field.getName(), o);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            for (Field field : rightFields) {
                String name = field.getName();
                if (map.containsKey(name)){
                    field.setAccessible(true);
                    field.set(rightValue, map.get(name));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return rightValue;
    }
}
