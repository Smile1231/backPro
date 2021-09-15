package com.zys.service;

import com.zys.pojo.po.SwiperItems;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @create 2021-03-09-4:22 下午
 * @Description 轮播图业务逻辑层
 */
public interface ISwiperItemsService {

    List getSwiperItems();

    //上传操作
    Integer uploadSwiperItems(SwiperItems swiperItems);

    List<SwiperItems> getAllSwiperItems();

    Integer deleteSwiperById(String id);

}
