package com.coin.shadow.kits;

import com.google.common.collect.Lists;

import java.util.List;
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
        if (StringKits.isBlank(regex) || StringKits.isBlank(target)){
            return false;
        }
        Pattern pattern = compile(regex, true);
        Matcher matcher = pattern.matcher(target);
        return matcher.matches();
    }


    public static String matchFirst(String regex, String target, int group){
        Pattern pattern = compile(regex, true);
        Matcher matcher = pattern.matcher(target);
        while (matcher.find()){
            return matcher.group(group).trim();
        }
        return "";
    }

    public static String matchFirst(String regex, String target, String name){
        Pattern pattern = compile(regex, true);
        Matcher matcher = pattern.matcher(target);
        while (matcher.find()){
            return matcher.group(name).trim();
        }
        return "";
    }

    public static List<String> matchGroup(String regex, String target, int group){
        List<String> ret = Lists.newArrayList();
        Pattern pattern = compile(regex, true);
        Matcher matcher = pattern.matcher(target);
        while (matcher.find()){
            ret.add(matcher.group(group));
        }
        return ret;
    }
    public static List<String> matchGroup(String regex, String target, String name){
        List<String> ret = Lists.newArrayList();
        Pattern pattern = compile(regex, true);
        Matcher matcher = pattern.matcher(target);
        while (matcher.find()){
            ret.add(matcher.group(name));
        }
        return ret;
    }

    /***
     *
     * @param regex  正则表达式
     * @param target 匹配所有
     * @return
     */
    public static List<String> matchAll(String regex, String target){
        List<String> ret = Lists.newArrayList();
        Pattern pattern = compile(regex, true);
        Matcher matcher = pattern.matcher(target);
        while (matcher.find()){
            ret.add(matcher.group());
        }
        return ret;
    }

    /***
     *
     * @param regex 正则表达式
     * @param ignore 是否区分大小写
     * @return
     */
    public static Pattern compile(String regex, boolean ignore){
        return  ignore ? Pattern.compile(regex) : Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }
}
