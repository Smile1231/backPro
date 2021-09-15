package com.zys.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cy
 * @create 2021-03-09-3:58 下午
 * @Description 轮播图对应实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("SwiperItems")
public class SwiperItems {
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer ID;
    @TableField("imageName")
    private String imageName;
    @TableField("ImageUrlPath")
    private String imageUrlPath;
    @TableField("uploadtime")
    private String uploadtime;

}
