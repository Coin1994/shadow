package com.coin.shadow.kits;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/29 17:48
 * @description：数组小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class ArrayKits {
    private ArrayKits(){
    }

    public static boolean isEmpty(final Object[] array){
        return getLength(array) == 0;
    }

    public static int getLength(final Object[] array){
        return ObjectKits.isNull(array) ? 0 : Array.getLength(array);
    }
}
