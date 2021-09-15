package com.zys.dao;

import com.zys.pojo.po.HotContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cy
 * @create 2021-03-14-2:44 下午
 * @Description 调用热门内容视图
 */
@Repository
public interface IHotContentMapper {

    List<HotContent> getHotContent();

}
