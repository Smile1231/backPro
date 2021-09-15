package com.zys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zys.pojo.po.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author cy
 * @create 2021-02-02-4:40 下午
 * @Description 操作UserInfo表的映射接口
 */
@Transactional
@Repository
public interface IUserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 添加微信用户，这里是调用了mysql的存储过程
     *
     * @param userInfo
     * @return
     */
    Integer addUser(UserInfo userInfo);

    Integer addUserInfo(UserInfo userInfo);

}
