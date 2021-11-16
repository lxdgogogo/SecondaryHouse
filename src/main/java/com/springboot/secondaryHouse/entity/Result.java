package com.springboot.secondaryHouse.entity;

import lombok.Data;

@Data
public class Result {
    //响应码
    private Integer code;
    //信息
    private String message;
    //返回数据
    private Object data;

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }
    //省略getter、setter、构造方法
}
