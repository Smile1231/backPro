package com.zys.service;

import com.zys.pojo.po.HotContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cy
 * @create 2021-03-14-2:51 下午
 * @Description 热门内容业务逻辑层
 */
public interface IHotContentService {
    List<HotContent> getHotContent();
}
