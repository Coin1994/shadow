package com.coin.shadow.kits;

import java.util.Random;
import java.util.UUID;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/11 9:35
 * @description：随机数小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class RandomKits {
    /***
     * 禁止外部初始化
     */
    private RandomKits(){
    }

    /***
     * 产生一个随机数，默认启用字母混合
     * @param length 字符长度
     * @return
     */
    public static String getRandom(int length){
        return getRandom(length, true);
    }

    /***
     * 产生一个随机数
     * @param length 字符长度
     * @param mixed  是否含有字母
     * @return
     */
    public static String getRandom(int length, boolean mixed){
        StringBuffer ret = new StringBuffer();
        if (mixed){
            for (int i = 0; i < length ; i++) {
                boolean flag = random.nextInt(2) % 2 == 0;
                if (flag){
                    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    ret.append((char) (choice + random.nextInt(26)));
                }else {
                    ret.append(random.nextInt(10));
                }
            }
        }else {
            for (int i = 0; i < length ; i++) {
                ret.append(random.nextInt(10));
            }
        }
        return ret.toString();
    }

    /**
     * 产生一个 UUID 去除 “-”
     * @return
     */
    public static String buildUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }



    private static Random random = new Random();
}
