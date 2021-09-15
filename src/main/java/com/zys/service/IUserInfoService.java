package com.zys.service;


import com.zys.pojo.po.UserInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * @author cy
 * @create 2021-02-02-8:44 下午
 * @Description Userinfo 表的业务逻辑层
 */
public interface IUserInfoService {

    /**
     * 将微信用户的信息存入mysql，调用存储过程实现
     *
     * @param userInfo
     * @return
     */
    Integer addUser(UserInfo userInfo);

    Integer addUserInfo(UserInfo userInfo);

    Integer updateUserFavor(String openId, String courseId);

    String[] findFavorId(String openId);

    List<UserInfo> getHistoryByOpenId(String openId);

    Integer addHistory(String openId, String courseId);

    Integer deleteHistoryByCourseId(String openId, String courseId);

    String[] findHistoryIdsByOpenId(String openId);

    Integer deleteAllHistoryByOpenId(String openId);

    List<UserInfo> getAllUserInfo();

    Integer deleteUserByOpenId(String id);

}
