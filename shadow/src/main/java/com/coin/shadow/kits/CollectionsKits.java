package com.coin.shadow.kits;

import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/10 9:42
 * @description：
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class CollectionsKits {
    /***
     * 禁止外部初始化
     */
    private CollectionsKits(){
    }

    /**
     * 判断集合是否为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /***
     * 判断集合是否不为空
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /***
     * 判断Map是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /***
     *判断Map是否不为空
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /***
     * 返回一个空的集合
     * @return
     */
    public static List emptyList(){
        return Collections.EMPTY_LIST;
    }

    /**
     * 返回一个空的Map
     * @return
     */
    public static Map emptyMap(){
        return Collections.EMPTY_MAP;
    }

    /***
     * 将 list 转换成 map
     * @param list
     * @param <Value>
     * @return
     */
    public static <Value> Map<Integer, Value> listToMap(List<Value> list){
        if (isEmpty(list)){
            return emptyMap();
        }
        Map<Integer,Value> map = Maps.newHashMap();
        for (Value value : list) {
            map.put(list.indexOf(value), value);
        }
        return map;
    }
}
