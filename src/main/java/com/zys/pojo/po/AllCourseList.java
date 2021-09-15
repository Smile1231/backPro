package com.zys.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cy
 * @create 2021-03-15-11:47 上午
 * @Description 全部课程实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("v_all_list")
@ApiModel("课程列表实体")
public class AllCourseList implements Serializable {
    @TableField("ID")
    private Integer ID;
    @TableField("title")
    @ApiModelProperty("标题")
    private String title;
    @TableField("courseImageUrlPath")
    @ApiModelProperty("图片URL链接")
    private String courseImageUrlPath;
    private String description;
    @TableField("learnNum")
    @ApiModelProperty("学习人数")
    private Integer learnNum;
    @TableField("teacherSchool")
    @ApiModelProperty("老师院校")
    private String teacherSchool;
    @TableField("courseState")
    @ApiModelProperty("课程状态码")
    private Integer courseState;
}
