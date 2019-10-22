package com.coin.shadow.func;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 9:51
 * @description：执行一个动作
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
@FunctionalInterface
public interface Action <T> {
    T apply(T data);
}
