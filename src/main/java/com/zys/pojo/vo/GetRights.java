package com.zys.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cy
 * @create 2021-02-19-11:26 上午
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRights implements Serializable {

    private Integer id;
    private String authname;
    private String level;
    private String pid;
    private String path;

}
