package com.zys.exception;

import com.zys.pojo.num.ResultCode;
import lombok.Getter;

/**
 * @author cy
 * @create 2021-03-14-11:06 上午
 * @Description 自定义异常类
 */
@Getter
public class APIException extends RuntimeException {

    private Integer code;

    private String msg;

    public APIException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

}
