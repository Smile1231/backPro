package com.zys.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cy
 * @create 2021-02-18-11:01 上午
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    private Integer id;
    private String username;
    private String mobile;
    private Integer type;
    private String email;
    private String create_time;
    private boolean mg_state;
    private String role_name;
}
