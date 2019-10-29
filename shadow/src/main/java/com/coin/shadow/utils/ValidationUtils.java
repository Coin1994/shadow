package com.coin.shadow.utils;

import com.coin.shadow.kits.RegexKits;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/29 15:59
 * @description： 常规验证
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class ValidationUtils {
    /***
     * 禁止外部初始化
     */
    private ValidationUtils(){
    }

    public static boolean checkNickName(String nickname){
        return RegexKits.match(NICKNAME_REGEX, nickname);
    }

    public static boolean checkPassword(String password){
        return RegexKits.match(PASSWORD_REGEX, password);
    }

    public static  boolean checkUrl(String url){
        return RegexKits.match(URL_REGEX, url);
    }

    public static boolean checkIp(String ip){
        return RegexKits.match(IP_REGEX, ip);
    }

    // 昵称正则匹配6 - 20位字母
    public static final String NICKNAME_REGEX = "^[a-zA-Z]\\w{6,20}$";
    // 密码正则匹配6 - 20位字母数字
    public static final String PASSWORD_REGEX = "^[a-zA-Z0-9]{6,20}$";
    // URL 正则
    public static final String URL_REGEX = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    // IP 正则
    public static final String IP_REGEX = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

}
