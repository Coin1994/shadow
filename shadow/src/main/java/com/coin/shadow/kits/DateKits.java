package com.coin.shadow.kits;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/10 9:32
 * @description：时间处理小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class DateKits {
    /***
     * 禁止外部初始化
     */
    private DateKits(){
    }

    /***
     * 返回系统当前时间戳 10位 unix time 时间戳
     * @return
     */
    public static int nowTime(){
        return Integer.parseInt(String.valueOf(nowTimeMillis() / 1000L));
    }

    /***
     * 返回系统当前时间戳 13位 unix time 时间戳 毫秒级
     * @return
     */
    public static long nowTimeMillis(){
        return System.currentTimeMillis();
    }

    /***
     * 返回系统当前日期
     * @return
     */
    public static Date nowDate(){
        return new Date(System.currentTimeMillis());
    }

    /***
     * 将 long 类型的时间错转换成日期
     * @param timestamp unix time 时间戳
     * @return
     */
    public Date getTime(final long timestamp){
        return new Date(timestamp);
    }

    /***
     * 将 int 类型的时间错转换成日期
     * @param timestamp unix time 时间戳
     * @return
     */
    public Date getTime(final int timestamp){
        return new Date(timestamp);
    }


    /***
     * 将Date类型 转化成 String类型
     * @param date
     * @return
     */
    public static String getStringFromDate(Date date){
        return getStringFromDate(date, DEFAULT_DATE_FORMAT);
    }

    /***
     * 将Date类型 转化成 String类型
     * @param date      时间日期
     * @param format    正则匹配格式
     * @return
     */
    public static String getStringFromDate(Date date, String format){
        if (date == null){
            return null;
        }
        if (StringUtils.isBlank(format)){
            return getStringFromDate(date,DEFAULT_DATE_FORMAT);
        }
        try {
            return new SimpleDateFormat(format,Locale.US).format(date);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /***
     * 将String类型转化成 Date类型
     * @param time
     * @return
     */
    public static Date getDateFromString(String time){
        return getDateFromString(time, DEFAULT_DATE_FORMAT);
    }

    /***
     * 将String类型转化成 Date类型
     * @param time
     * @param format
     * @return
     */
    public static Date getDateFromString(String time, String format){
        if (StringUtils.isBlank(time)){
            return null;
        }

        if (StringUtils.isBlank(format)){
            return getDateFromString(time, DEFAULT_DATE_FORMAT);
        }

        try {
            return new SimpleDateFormat(format, Locale.US).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Date addTime(final Date date, final int calendarField, final int amount){
        if (ObjectKits.isNull(date)){
            return null;
        }

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendarField, amount);
        return calendar.getTime();
    }


    // 默认的时间格式
    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public final static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
    public final static String LONG_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss:sss";
    public final static String DEFAULT_DATE_FORMAT_WITHOUT_SEPARATOR ="yyyyMMdd";
    public final static String SIMPLE_DATE_FORMAT_WITHOUT_SEPARATOR ="yyyyMMddhhmmss";
    public final static String LONG_DATE_FORMAT_WITHOUT_SEPARATOR ="yyyyMMddhhmmsssss";


    public static void main(String argc[]){
        System.out.println(getStringFromDate(new Date()));
        System.out.println(getStringFromDate(new Date(),SIMPLE_DATE_FORMAT));
        System.out.println(getStringFromDate(new Date(),LONG_DATE_FORMAT));
        System.out.println(getStringFromDate(new Date(),DEFAULT_DATE_FORMAT_WITHOUT_SEPARATOR));
        System.out.println(getStringFromDate(new Date(),SIMPLE_DATE_FORMAT_WITHOUT_SEPARATOR));
        System.out.println(getStringFromDate(new Date(),LONG_DATE_FORMAT_WITHOUT_SEPARATOR));

        System.out.println(getDateFromString("2018-06-23"));
        System.out.println(getDateFromString("2018-06-23 05:34:28", SIMPLE_DATE_FORMAT));
        System.out.println(getDateFromString("2018-06-23 05:35:38:038", LONG_DATE_FORMAT));
        System.out.println(getDateFromString("20180623", DEFAULT_DATE_FORMAT_WITHOUT_SEPARATOR));
        System.out.println(getDateFromString("20180623054022", SIMPLE_DATE_FORMAT_WITHOUT_SEPARATOR));
        System.out.println(getDateFromString("20180623054000022", LONG_DATE_FORMAT_WITHOUT_SEPARATOR));
    }

}
