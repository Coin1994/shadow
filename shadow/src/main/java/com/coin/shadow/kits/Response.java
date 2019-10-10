package com.coin.shadow.kits;

import lombok.*;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/10 10:08
 * @description：通用响应小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */

@Data
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Response<Type> implements java.io.Serializable{

    private final static <Type> Response<Type> result(Integer code, String desc, Type data) {
        return new Response<>(code, desc, data, System.currentTimeMillis());
    }

    private Integer     code;
    private String      desc;
    private Type        data;
    private Long        timestamp;
}