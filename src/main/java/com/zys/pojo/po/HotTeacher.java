package com.zys.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cy
 * @create 2021-03-14-9:38 下午
 * @Description 热门教师实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("v_hot_teacher")
public class HotTeacher implements Serializable {

    @TableField("ID")
    private Integer ID;
    @TableField("teacherName")
    private String teacherName;
    @TableField("teacherSchool")
    private String teacherSchool;
    @TableField("teacherImageUrlPath")
    private String teacherImageUrlPath;
}
