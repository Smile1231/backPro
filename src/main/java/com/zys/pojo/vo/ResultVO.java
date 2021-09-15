package com.zys.pojo.vo;

import com.zys.pojo.num.ResultCode;
import lombok.Getter;

/**
 * @author cy
 * @create 2021-03-14-10:51 上午
 * @Description 统一消息返回体
 */
@Getter
public class ResultVO<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    //构造返回成功参数
    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
