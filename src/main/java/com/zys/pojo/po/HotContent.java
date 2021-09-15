package com.zys.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cy
 * @create 2021-03-14-2:47 下午
 * @Description 热门内容实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotContent implements Serializable {

    @TableField("ID")
    private Integer ID;

    private String title;

    @TableField("courseImageUrlPath")
    private String courseImageUrlPath;

    @TableField("description")
    private String description;

}
