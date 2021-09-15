package com.zys.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cy
 * @create 2021-04-19-9:50 上午
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Upload implements Serializable {
    private String name;
    private String url;
}
