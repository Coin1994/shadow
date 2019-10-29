package com.coin.shadow.utils;

import com.coin.shadow.kits.RegexKits;

import java.io.File;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 15:17
 * @description：
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class EmailUtils {
    /***
     * 禁止外部初始化
     */
    private EmailUtils(){
    }

    /***
     * 检测是否为邮箱
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        return RegexKits.match(EMAIL_REGEX, email);
    }

    /***
     * 发送邮件
     * @param from      发送方
     * @param to        接收方
     * @param message   消息
     * @return
     */
    public static boolean sendEmail(String from, String to, String message){
        return sendEmail(from, to, message, null);
    }

    /***
     * 发送邮件
     * @param from      发送方
     * @param to        接收方
     * @param message   消息
     * @param file      文件
     * @return
     */
    public static boolean sendEmail(String from, String to, String message, File file){
        return true;
    }


    private static final String EMAIL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
}
