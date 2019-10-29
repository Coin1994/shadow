package com.coin.shadow.net;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/29 19:18
 * @description：响应状态
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public interface ResponseStatus extends java.io.Serializable{
    Integer getCode();
    String  getDesc();
}
