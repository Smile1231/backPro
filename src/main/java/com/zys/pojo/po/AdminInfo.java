package com.zys.pojo.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.dreamyoung.mprelation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author cy
 * @create 2021-02-04-1:43 下午
 * @Description 数据库表AdminInfo对应的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("AdminInfo")
@AutoLazy
public class AdminInfo implements Serializable {

    @TableId(value = "ID")
    private Integer id;

    private String username;

    private String password;

    private String createtime;

    @TableField("role_id")
    private Integer roleId;

    //多对多，一个用户可能拥有多个角色
    @TableField(exist = false)//是否为数据库字段
    private List<RoleInfo> roles;
}
