package com.zys.pojo.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zys.pojo.vo.ResponseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author cy
 * @create 2021-02-02-4:38 下午
 * @Description 数据库UserInfo对应的实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userInfo")
@ApiModel("用户信息实体类")
public class UserInfo implements Serializable {

    @TableId("openId")
    private String openId;
    @TableField("nickName")
    private String nickName;
    private String gender;
    private String country;
    private String province;
    private String city;
    @TableField("imageUrlPath")
    @ApiModelProperty("头像图片URl")
    private String imageUrlPath;
    @TableField("createtime")
    @ApiModelProperty("创建时间")
    private String createtime;

    @TableField("favor")
    @ApiModelProperty("收藏的课程ID")
    private String favor;

    @TableField("history")
    @ApiModelProperty("历史浏览编号")
    private String history;

    @TableField("historyState")
    @ApiModelProperty("1--未删除，0--删除")
    private String historyState;

    @TableField(exist = false)
    private List<String> favorCourseName;


    @TableField(exist = false)
    private List<String> historyCourseName;

}
