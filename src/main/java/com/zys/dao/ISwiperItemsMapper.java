package com.zys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zys.pojo.po.SwiperItems;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cy
 * @create 2021-03-09-4:10 下午
 * @Description 轮播图持久层
 */
@Transactional
@Repository
public interface ISwiperItemsMapper extends BaseMapper<SwiperItems> {

    Integer uploadSwiperItems(SwiperItems swiperItems);
}
