package com.coin.shadow.kits;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/29 8:36
 * @description：正则匹配小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class RegexKits {
    /***
     * 禁止外部初始化
     */
    private RegexKits(){
    }

    /***
     * 正则 match
     * @param regex
     * @param target
     * @return
     */
    public static boolean match(String regex, String target){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        return matcher.matches();
    }
}
