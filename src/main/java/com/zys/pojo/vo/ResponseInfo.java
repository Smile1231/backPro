package com.zys.pojo.vo;

import com.baomidou.mybatisplus.extension.api.R;
import com.zys.pojo.base.AjaxResponseBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cy
 * @create 2021-02-02-5:25 下午
 * @Description 返回信息的实体类基础类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo<R> implements Serializable {

    //是否成功
    private Boolean success;

    //返回码
    private Integer code;

    //返回消息
    private String message;

    private R data;
}
