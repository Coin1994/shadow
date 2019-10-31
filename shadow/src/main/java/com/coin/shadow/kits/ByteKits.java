package com.coin.shadow.kits;


import java.nio.charset.Charset;
import java.util.Stack;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/10 9:24
 * @description：字节处理小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class ByteKits {
    /***
     * 禁止外部初始化
     */
    private ByteKits(){
    }
    /***
     * 字符串转字节数组
     * @param data 待转换数据
     * @return
     */
    public static byte[] stringToByteArray(final String data){
        if (StringKits.isBlank(data)){
            return null;
        }
        return data.getBytes(Charset.forName("UTF-8"));
    }

    /***
     * 字节数组转字符串
     * @param data 待转换数据
     * @return
     */
    public static String byteArrayToString(final byte[] data){
        if (data == null){
            return null;
        }
        return new String(data,Charset.forName("UTF-8"));
    }

    /***
     * 字节数组转十六进制字符串
     * @param data 待转换数据
     * @return
     */
    public static String byteArrayToHexString(final byte[] data){
        final char [] HEX_DIGITS_CHAR_ARRAY = HEX_DIGITS.toCharArray();
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (int index = 0; index < data.length; index++) {
            sb.append(HEX_DIGITS_CHAR_ARRAY[(data[index] >> 4) & 0x0f]);
            sb.append(HEX_DIGITS_CHAR_ARRAY[data[index] & 0x0f]);
        }
        return sb.toString();
    }

    /***
     * 十六进制字符串转字节数组
     * @param data 待转换数据
     * @return
     */
    public static byte[] hexStringToByteArray(final String data){
        if (StringKits.isBlank(data)){
            return new byte[0];
        }
        int length = data.length() / 2;
        byte[] ret = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            ret[i] = Integer.valueOf(data.substring(pos, pos + 2), 16).byteValue();
        }
        return ret;
    }

    /***
     * 字符串转成十六进制字符串
     * @param data 待转换数据
     * @return
     */
    public static String stringToHexString(final String data){
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            int ch = (int) data.charAt(i);
            ret.append(Integer.toHexString(ch));
        }
        return ret.toString();
    }

    /***
     * 十六进制字符串转字符串
     * @param data 待转换数据
     * @return
     */
    public static String hexStringToString(final String data) {
        String ret = "";
        for (int i = 0; i < data.length() / 2; i++) {
            int pos = i * 2;
            ret = ret + (char) Integer.valueOf(data.substring(pos, pos + 2), 16).byteValue();
        }
        return ret;
    }
    /***
     * 将10进制数转化成62进制字符
     * @param id
     * @param length
     * @return
     */
    public static String convert10To62(int id, int length){
        int target = id;
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        char [] CHAR_DIGITS_CHAR_ARRAY = CHAR_DIGITS.toCharArray();
        while (target != 0){
            stack.add(CHAR_DIGITS_CHAR_ARRAY[new Integer((target - (target / 62)*62))]);
            target = target / 62;
        }
        for (;!stack.isEmpty();){
            sb.append(stack.pop());
        }
        int len = sb.length();
        StringBuffer prefix = new StringBuffer();
        for (int i = 0; i < length - len; i++) {
            prefix.append("0");
        }

        return prefix.toString() + sb.toString();
    }

    /***
     * 将62进制转化成10进制
     * @param target
     * @return
     */
    public static String convertBase62ToDecimal(String target) {
        int decimal = 0, base = 62, kpi = 0, cnt = 0;

        byte ident[] = target.getBytes();
        for ( int i = ident.length - 1; i >= 0; i-- ) {
            int num = 0;
            if ( ident[i] > 48 && ident[i] <= 57 ) {
                num = ident[i] - 48;
            }
            else if ( ident[i] >= 65 && ident[i] <= 90 ) {
                num = ident[i] - 65 + 10;
            }
            else if ( ident[i] >= 97 && ident[i] <= 122 ) {
                num = ident[i] - 97 + 10 + 26;
            }
            kpi = (int) Math.pow(base, cnt);
            decimal += num * kpi;
            cnt++;
        }
        return String.format( "%08d", decimal);
    }


    /***
     * 将 short 转换成字节
     * @param value
     * @return
     */
    public final static byte getByte(short value){
        return Short.valueOf(value).byteValue();
    }

    /***
     * 将 int 转换成字节
     * @param value
     * @return
     */
    public final static byte getByte(int value){
        return Integer.valueOf(value).byteValue();
    }

    /***
     * 将 long 转换成字节
     * @param value
     * @return
     */
    public final static byte getByte(long value){
        return Long.valueOf(value).byteValue();
    }

    /***
     * 将 float 转换成字节
     * @param value
     * @return
     */
    public final static byte getByte(float value){
        return Float.valueOf(value).byteValue();
    }

    /***
     * 将 double 转换成字节
     * @param value
     * @return
     */
    public final static byte getByte(double value){
        return Double.valueOf(value).byteValue();
    }

    private final static String CHAR_DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private final static String HEX_DIGITS = "0123456789ABCDEF";
}
