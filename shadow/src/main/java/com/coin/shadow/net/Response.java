package com.coin.shadow.net;

import lombok.*;

/**
 * @author ：孙伟
 * @date ：Created in 2019/6/29 0:06
 * @description：响应工具类
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
// TODO 这里结合公司业务需要将Type类型的数据转JSON.toString()
@Data
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Response<Type> implements java.io.Serializable {

    public final static  <Type> Response<Type> success(){
        return result(DefaultResponseStatus.SUCCESS, null);
    }

    public final static  <Type> Response<Type> success(Type data){
        return result(DefaultResponseStatus.SUCCESS, data);
    }

    public final static  <Type> Response<Type> success(String message){
        return result(DefaultResponseStatus.SUCCESS.getCode(), message, null);
    }

    public final static  <Type> Response<Type> failed(){
        return result(DefaultResponseStatus.FAILED, null);
    }

    public final static  <Type> Response<Type> failed(Type data){
        return result(DefaultResponseStatus.FAILED, data);
    }

    public final static  <Type> Response<Type> failed(String message){
        return result(DefaultResponseStatus.FAILED.getCode(), message, null);
    }

    public final static  <Type> Response<Type> result(ResponseStatus status){
        return result(status.getCode(), status.getDesc(), null);
    }

    public final static <Type> Response<Type> result(ResponseStatus status, Type data){
        return result(status.getCode(), status.getDesc(), data);
    }
    private final static <Type> Response<Type> result(Integer code, String desc, Type data) {
        return new Response<>(code, desc, data, System.currentTimeMillis());
    }

    private Integer     code;
    private String      desc;
    private Type        data;
    private Long        timestamp;

    // 默认响应状态
    private enum DefaultResponseStatus implements ResponseStatus {
        SUCCESS(200, "操作成功"),
        FAILED (500, "操作失败"),
        ;
        DefaultResponseStatus(Integer code, String desc){
            this.code = code;
            this.desc = desc;
        }
        @Override
        public Integer getCode() {
            return code;
        }

        @Override
        public String getDesc() {
            return desc;
        }

        private Integer code;
        private String  desc;
    }

}
