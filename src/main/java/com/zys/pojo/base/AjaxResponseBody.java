package com.zys.pojo.base;

/**
 * @author cy
 * @create 2021-02-04-12:29 下午
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 前后端项目，返回给前端需要保存的信息，当前用户信息，token
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AjaxResponseBody implements Serializable {

    private String status;    // 状态
    private String msg;    // 消息

}
