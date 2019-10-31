package com.coin.shadow.kits;

import com.google.common.collect.Lists;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author ：孙伟
 * @date ：Created in 2019/6/30 23:37
 * @description：加密小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */

public final class CryptoKits {
    /***
     * 禁止外部初始化
     */
    private CryptoKits(){
    }

    /***
     * 使用 MD5 的方式加密
     * @param data 待加密数据
     * @return
     */
    public static String md5(final String data){
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            return ByteKits.byteArrayToHexString(md.digest((data).getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用MD5加密
     * @param data 待加密数据
     * @param key  加密Key
     * @return
     */
    public static String md5(final String data, final String key) {
        return md5(String.format("%s%s" ,data ,key));
    }
    /***
     * 使用 SHA1 的方式加密
     * @param data 待加密数据
     * @return
     */
    public static String sha1(final String data){
        try {
            MessageDigest md = MessageDigest.getInstance(SHA1);
            return ByteKits.byteArrayToHexString(md.digest((data).getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用HmacSHA1进行加密(推荐)
     * @param data 待加密数据
     * @param key  加密Key
     * @return
     */
    public static String hmacSha1(final String data, final String key) {
        try {
            byte[] keyBytes = key.getBytes(Charset.forName("UTF-8"));
            SecretKeySpec signKey = new SecretKeySpec(keyBytes, HMACSHA1);
            Mac mac = Mac.getInstance(HMACSHA1);
            mac.init(signKey);
            return ByteKits.byteArrayToHexString(mac.doFinal(data.getBytes()));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 默认提供不待过滤器的实现
     * @param map
     * @return 拼接后的字符串
     */
    public static <T> String link(Map<String, T> map){
        return link(map, null);
    }

    /**
     * 把数组所有的元素排序, 并且按照 key=value 的模式用 & 拼接成字符串
     * @param map       需要排序并参与字符串拼接的 map
     * @param filter    自定义过滤方法
     * @return 拼接后的字符串
     */
    public static <T> String link(Map<String, T> map, Function<String, Boolean> filter){
        if (CollectionsKits.isEmpty(map)){
            return null;
        }
        List<String> keys = Lists.newArrayList(map.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if ((filter != null && filter.apply(key))){
                // 如果过滤器不为空并且完成过滤 则跳过
                continue;
            }
            T value = map.get(key);
            if (StringKits.isEmpty(value.toString())){
                // 如果值为空 则跳过
                continue;
            }
            sb.append(key).append("=").append(value).append("&");
        }
        int size = sb.length() -1;
        if (sb.indexOf("&", size) > 0){
            sb.deleteCharAt(size);
        }
        return sb.toString();
    }

    private static final String MD5 = "MD5";
    private static final String SHA1 = "SHA1";
    private static final String HMACSHA1 = "HmacSHA1";
}
