package com.zys.service;

import com.github.dreamyoung.mprelation.IService;
import com.zys.pojo.po.AdminInfo;
import com.zys.pojo.po.UserInfo;
import com.zys.pojo.vo.ResponseInfo;

/**
 * @author cy
 * @create 2021-02-04-3:03 下午
 * @Description
 */
public interface IAdminInfoService {

    /**
     * 根据username 获取AdminInfo
     *
     * @param username
     * @return
     */
    ResponseInfo loadAdminInfoByUsername(String username);
}
