package com.coin.shadow.utils;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 15:16
 * @description：手机号码工具类
 * @modified By：孙伟
 * @version: v1.0.0.0
 */


import com.coin.shadow.kits.RegexKits;

/***
 * @note
 * 中国移动号段 134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198
 * 中国电信号段 133、149、153、173、177、180、181、189、199
 * 中国联通号段 130、131、132、145、155、156、166、175、176、185、186
 * 其他号段
 * 14号段以前为上网卡专属号段，如中国联通的是145，中国移动的是147等等。
 * 虚拟运营商
 * 电信：1700、1701、1702
 * 移动：1703、1705、1706
 * 联通：1704、1707、1708、1709、171
 * 卫星通信：1349
 */
public final class PhoneUtils {
    /***
     * 禁止外部初始化
     */
    private PhoneUtils(){
    }

    /***
     * 是否为手机号码
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone){
        return isCMCCMobile(phone) || isCTCCMobile(phone) || isCUCCMobile(phone) || isKnownMobile(phone);
    }
    /**
     * 是否为移动手机号码
     * @param phone
     * @return
     */
    public static boolean isCMCCMobile(String phone){
        return RegexKits.match(CMCC_PHONE_REGEX, phone);
    }
    /**
     * 是否为电信手机号码
     * @param phone
     * @return
     */
    public static boolean isCTCCMobile(String phone){
        return RegexKits.match(CTCC_PHONE_REGEX, phone);
    }
    /**
     * 是否为联通手机号码
     * @param phone
     * @return
     */
    public static boolean isCUCCMobile(String phone){
        return RegexKits.match(CUCC_PHONE_REGEX, phone);
    }

    /***
     * 是否为手机号码
     */
    public static boolean isKnownMobile(String phone){
        return RegexKits.match(DEFAULT_PHONE_REGEX, phone);
    }


    public static String getMobileServiceProvider(String phone){
        if (isCMCCMobile(phone)){
            return "CMCC";
        }else if (isCTCCMobile(phone)){
            return "CTCC";
        }else if (isCUCCMobile(phone)){
            return "CUCC";
        }
        return "UNKNOWN";
    }

    // 中国移动号码格式验证 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
    private static final String CMCC_PHONE_REGEX = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";
    // 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700,173,199
    private static final String CTCC_PHONE_REGEX = "(^1(33|53|77|73|99|8[019])\\d{8}$)|(^1700\\d{7}$)";
    // 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
    private static final String CUCC_PHONE_REGEX = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";
    // 目前整理的手机格式
    private static final String DEFAULT_PHONE_REGEX= "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
}
