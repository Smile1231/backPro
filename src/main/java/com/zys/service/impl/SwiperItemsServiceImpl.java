package com.zys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zys.dao.ISwiperItemsMapper;
import com.zys.pojo.po.SwiperItems;
import com.zys.service.ISwiperItemsService;
import com.zys.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @create 2021-03-09-4:24 下午
 * @Description
 */
@Service
public class SwiperItemsServiceImpl implements ISwiperItemsService {

    @Autowired
    private ISwiperItemsMapper swiperItemsMapper;


    /**
     * 获取轮播图
     *
     * @return
     */
    @Override
    public List getSwiperItems() {

        QueryWrapper<SwiperItems> wrapper = new QueryWrapper<>();
        List<Map<String, Object>> swiperItemsList = swiperItemsMapper.selectMaps(wrapper);

        return swiperItemsList;
    }

    /**
     * 进行图片的上传
     *
     * @return
     */
    @Override
    public Integer uploadSwiperItems(SwiperItems swiperItems) {

        String date = DateUtils.Date2String(new Date(), "yyyy-MM-dd HH:mm:ss");
        swiperItems.setUploadtime(date);
        Integer integer = swiperItemsMapper.uploadSwiperItems(swiperItems);
        return integer;
    }

    @Override
    public List<SwiperItems> getAllSwiperItems() {
        return swiperItemsMapper.selectList(new QueryWrapper<SwiperItems>());
    }

    @Override
    public Integer deleteSwiperById(String id) {
        return swiperItemsMapper.deleteById(id);
    }
}
