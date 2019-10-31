package com.coin.shadow.func;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 9:53
 * @description：
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
@FunctionalInterface
public interface Filter<T> {
    boolean apply(T data);
}
