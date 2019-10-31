package com.coin.shadow.kits;
import java.util.UUID;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 14:32
 * @description： 字符串处理小工具 TODO 为后面去除 commons-lang3 做一个准备
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class StringKits {
    /***
     * 禁止外部初始化
     */
    private StringKits(){
    }
    /***
     * 检验字符串是否为空
     * 不严谨 如 TAB制表符 回车符 ...
     * @param cs
     * @return
     */
    public final static boolean isEmpty(CharSequence cs){
        return cs == null || cs == "" || cs.length() == 0;
    }

    /***
     * 检验字符串是否不为空
     * @param cs
     * @return
     */
    public final static boolean isNotEmpty(CharSequence cs){
        return !isEmpty(cs);
    }

    /***
     * 是否含空字符
     * @param css
     * @return
     */
    public final static boolean isAnyEmpty(final CharSequence ...css){
        if (ArrayKits.isEmpty(css)){
            return false;
        }
        for (final CharSequence cs: css) {
            if (isEmpty(cs)){
                return true;
            }
        }
        return false;
    }

    /***
     * 是否都为空字符
     * @param css
     * @return
     */
    public final static boolean isAllEmpty(final CharSequence ...css){
        if (ArrayKits.isEmpty(css)){
            return false;
        }
        for (final CharSequence cs: css) {
            if (isNotEmpty(cs)){
                return false;
            }
        }
        return true;
    }

    /***
     * 检验字符串是否为空白字符
     * @param cs
     * @return
     */
    public final static boolean isBlank(CharSequence cs){
        int len;
        if (cs != null && (len = cs.length()) != 0) {
            for(int i = 0; i < len; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /***
     * 检验字符串是否不为空白字符
     * @param cs
     * @return
     */
    public final static boolean isNotBlank(CharSequence cs){
        return !isBlank(cs);
    }

    /***
     * 返回32位UUID
     * @return
     */
    public final static String buildUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


    /**
     * 获取最后一个字符
     * @param target
     * @return
     */
    public final static String lastString(final String target){
        return isBlank(target) ? "" : target.substring(target.length() - 1);
    }

    /***
     * 将驼峰标识的命名的字符串转成下划线大写方式。
     * @param name
     * @return
     */
    public static String underscoreName(final String name){
        if (StringKits.isBlank(name)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : name.toCharArray()) {
            if (c.compareTo('a') < 0 && !Character.isDigit(c)){
                sb.append("_").append(c.toString().toLowerCase());
            }else {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }

    /***
     * 判断某字符串与一组字符串是否相等
     * @param target
     * @param css
     * @return
     */
    public static boolean equals(CharSequence target, CharSequence ... css){
        if (isEmpty(target) || ArrayKits.isEmpty(css)){
            return false;
        }
        for (CharSequence cs : css) {
            if (!cs.equals(target)){
                return false;
            }
        }
        return true;
    }
}
