package com.zys.service.impl;

import com.zys.dao.IHotContentMapper;
import com.zys.pojo.po.HotContent;
import com.zys.service.IHotContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cy
 * @create 2021-03-14-2:53 下午
 * @Description
 */
@Service
public class HotContentServiceImpl implements IHotContentService {

    @Autowired
    private IHotContentMapper hotContentMapper;

    @Override
    public List<HotContent> getHotContent() {
        List<HotContent> hotContent = hotContentMapper.getHotContent();
        return hotContent;
    }
}
