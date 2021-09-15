package com.zys.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import com.github.dreamyoung.mprelation.*;
import lombok.Data;

import java.util.List;

/**
 * @author cy
 * @create 2021-02-04-1:49 下午
 * @Description 数据库表RoleInfo对应的实体类
 */
@Data
@AutoLazy
@TableName("RoleInfo")
public class RoleInfo {
    @TableId(value = "rid")
    private Integer rid;
    private String rName;
    private String rDescription;

    @TableField(exist = false)
    private List<AdminInfo> admin;

//    value	字段值（驼峰命名方式，该值可无）
//    update	预处理 set 字段自定义注入
//    condition	预处理 WHERE 实体条件自定义运算规则
//    el	详看注释说明
//    exist	是否为数据库表字段（ 默认 true 存在，false 不存在 ）
//    strategy	字段验证 （ 默认 非 null 判断，查看 com.baomidou.mybatisplus.enums.FieldStrategy ）
//    fill	字段填充标记 （ FieldFill, 配合自动填充使用 ）
}
