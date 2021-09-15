package com.zys.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author cy
 * @create 2021-02-15-11:49 下午
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMenus implements Serializable {

    private Integer id;
    private String authName;
    private String path;
    private List<GetMenus> children;

}
