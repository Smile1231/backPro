package com.zys.pojo.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("AllStudyCourse")
public class AllStudyCourse {

    @TableId(value = "ID", type = IdType.AUTO)
    private long id;
    private String title;
    @TableField("courseImageUrlPath")
    private String courseImageUrlPath;
    private String description;
    @TableField("learnNum")
    private long learnNum;
    @TableField("uploadtime")
    private String uploadtime;
    @TableField("relatedTeacherID")
    private long relatedTeacherId;
    @TableField("courseState")
    private long courseState; // 0 -- 即将开课
    // 1 -- 已经开课
    // 2 -- 已结课
    @TableField("videoUrlPath")
    private String videoUrlPath;
    @TableField("favorOrNot")
    private long favorOrNot; // 0--未收藏 1---收藏
    @TableField("courseWeather")
    private String courseWeather;
    @TableField("courseTimer")
    private String courseTimer;
    @TableField("hotOrNot")
    private Integer hotOrNot;

    @Getter(AccessLevel.NONE)
    @TableField(exist = false)
    private boolean hotStateMsg;

    @Getter(AccessLevel.NONE)
    @TableField(exist = false)
    private String courseStateMsg;

    @TableField(exist = false)
    private String teacherSchool;

    @TableField(exist = false)
    private String teacherName;


    public boolean isHotStateMsg() {
        if (this.hotOrNot == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String getCourseStateMsg() {
        if (this.courseState == 0) {
            return "即将开课";
        } else if (this.courseState == 1) {
            return "已经开课";
        } else {
            return "已结束";
        }
    }
}
