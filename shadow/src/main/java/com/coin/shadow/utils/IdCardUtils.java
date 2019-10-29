package com.coin.shadow.utils;

import com.coin.shadow.kits.RegexKits;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 15:17
 * @description：
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class IdCardUtils {

    /***
     * 禁止外部初始化
     */
    private IdCardUtils(){
    }

    /***
     * 是否是合法的身份证
     * @param card
     * @return
     */
    public static boolean isIdCard(String card){
        return RegexKits.match(ID_CARD_REGEX, card);
    }

    /***
     * 1.[1-9]\\d{5} 地区代码，第一位不为0，共计6位。
     * 2.[1-9]\\d{3} 出生年份，年份第一位不为0，共计4位。
     * 3.((0[1-9])|(1[0-2])) 出生月份，月份第一位为0或者1，如果为0则第二位为1-9，如果为1则为0-2，共计2位。
     * 4.(([0|1|2][1-9])|3[0-1]) 出生日期，日期第一位为0或者1或者2或者3，如果为0、1、2则第二位为1-9，如果为3第二位为0-1
     * 5.((\\d{4})|\\d{3}X) 结尾可以为四位任意数字或者为三位数加大写X（此处注意传进身份证号大小写）
     */
    private static final String ID_CARD_REGEX = "^[1-9]\\d{5}[1-9]\\d{3}((0[1-9])|(1[0-2]))(([0|1|2][1-9])|3[0-1])((\\d{4})|\\d{3}X)$";

}
