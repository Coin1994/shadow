package com.coin.shadow.kits;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author ：孙伟
 * @date ：Created in 2019/7/25 22:25
 * @description：Url小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */

public final class UrlKits {
    /***
     * 禁止外部初始化
     */
    private UrlKits(){
    }
    
    /***
     * url 转 map
     * @param url
     * @return
     */
    public static Map<String, String> urlToMap(final String url){
        if (StringUtils.isBlank(url)){
            return CollectionsKits.emptyMap();
        }

        // index = -1 说明没有参数
        int index = url.indexOf("?");
        if (index == -1){
            return CollectionsKits.emptyMap();
        }

        // params 为空
        String params = url.substring(index + 1);
        if (StringUtils.isBlank(params)){
            return CollectionsKits.emptyMap();
        }

        String[] source = params.split("&");
        Map<String,String> map = Maps.newHashMap();
        for (String item:source) {
            String[] kv = item.split("=");
            map.put(kv[0],kv[1]);
        }
        return map;
    }

    /**
     * map 转 url
     * @param map
     * @return
     */
    public static String mapToUrl(Map<String, String> map){
        if (CollectionsKits.isEmpty(map)){
            return null;
        }

        StringBuffer sb = new StringBuffer();
        // 遍历keySet()
        for (String key : map.keySet()) {
            String value = map.get(key);
            if (StringUtils.isNotBlank(value)){
                String kv = key + "=" + value + "&";
                sb = sb.append(kv);
            }
        }

        String ret = sb.toString();
        if (StringUtils.isEmpty(ret)){
            return null;
        }
        // 去除最后一个&符号
        ret = ret.substring(0, ret.length() -1);
        return ret;
    }


    public static String encodeUrl(String url){
        if (StringUtils.isBlank(url)){
            return null;
        }

        try {
            return URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String decodeUrl(String url){
        if (StringUtils.isBlank(url)){
            return null;
        }

        try {
            return URLDecoder.decode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
