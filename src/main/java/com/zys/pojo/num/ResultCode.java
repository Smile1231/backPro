package com.zys.pojo.num;

import lombok.Getter;

/**
 * @author cy
 * @create 2021-03-14-10:32 上午
 * @Description 前端接口返回实体类
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "操作成功"),

    FAILED(201, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(500, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
