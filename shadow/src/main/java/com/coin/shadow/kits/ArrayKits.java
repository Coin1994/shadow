package com.coin.shadow.kits;

import java.lang.reflect.Array;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/29 17:48
 * @description：数组小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class ArrayKits {
    /***
     * 禁止外部初始化
     */
    private ArrayKits(){
    }

    public static boolean isEmpty(final Object[] array){
        return length(array) == 0;
    }

    public static int length(final Object[] array){
        return ObjectKits.isNull(array) ? 0 : Array.getLength(array);
    }
}
