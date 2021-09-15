package com.zys.pojo.po;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("TeacherDetails")
public class TeacherDetails {

    @TableId(value = "ID", type = IdType.AUTO)
    private long id;
    @TableField("teacherName")
    private String teacherName;
    @TableField("teacherSchool")
    private String teacherSchool;
    @TableField("teacherImageUrlPath")
    private String teacherImageUrlPath;
    @TableField("teacherDescription")
    private String teacherDescription;
    @TableField("uploadtime")
    private String uploadtime;
    @TableField("hotOrNot")
    private long hotOrNot;

    @TableField(exist = false)
    private boolean hotOrNotState;

}
