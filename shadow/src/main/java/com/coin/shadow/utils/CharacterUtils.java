package com.coin.shadow.utils;

import com.coin.shadow.kits.RegexKits;
/**
 * @author ：孙伟
 * @date ：Created in 2019/10/29 15:55
 * @description：字符辅助类
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class CharacterUtils {
    /***
     * 禁止外部初始化
     */
    private CharacterUtils(){
    }
    /***
     * 判断书否为英文
     * @param english
     * @return
     */
    public static boolean isEnglish(String english){
        return RegexKits.match(ENGLISH_REGEX, english);
    }

    /**
     * 是否为纯中文
     * @param chinese
     * @return
     */
    public static boolean isChinese(String chinese){
        return RegexKits.match(CHINESE_REGEX, chinese);
    }

    /***
     * 是否是纯数字
     * @param number
     * @return
     */
    public static boolean isNumber(String number){
        return RegexKits.match(NUMBER_REGEX, number);
    }

    /***
     * 是否是对应精度的数字
     * @param number
     * @param count
     * @return
     */
    public static boolean isDecimalNumber(String number, int count){
        return RegexKits.match(String.format(DECIMAL_NUMBER_REGEX, count), number);
    }

    private final static String CHINESE_REGEX = "^[\u4e00-\u9fa5],{0,}$";
    private final static String NUMBER_REGEX  = "^-?\\d+(\\.\\d+)?$";
    private final static String ENGLISH_REGEX  = "^[A-Za-z]+$";
    private final static String DECIMAL_NUMBER_REGEX =  "^-?(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,%d})?$";

    public static void main(String argc[]){
        System.out.println(CharacterUtils.isNumber("-0.02"));
        System.out.println(CharacterUtils.isDecimalNumber("-0.020",3));
    }

}
