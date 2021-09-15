package com.zys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zys.dao.IUserInfoMapper;
import com.zys.pojo.po.AllStudyCourse;
import com.zys.pojo.po.UserInfo;
import com.zys.service.IUserInfoService;
import com.zys.utils.DateUtils;
import com.zys.utils.List2Str;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author cy
 * @create 2021-02-02-8:50 下午
 * @Description
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoMapper userInfoMapper;

    @Autowired
    private StudyCourseServiceImpl studyCourseService;


    /**
     * 返回插入结果
     *
     * @param userInfo
     * @return 0 --- 插入成功   1----插入失败   2----已经有该用户
     */
    @Override
    //@Async("miniProExecutor")
    public Integer addUser(UserInfo userInfo) {
        //往mysql表中存入微信用户信息
        //首先需要判断当前表中是否存在该用户
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("openId", userInfo.getOpenId());
        Integer count = userInfoMapper.selectCount(wrapper);
        //进行判断
        if (count > 0) {
            return 2;
        } else {
            return userInfoMapper.addUser(userInfo);
        }
    }

    @Override
    public Integer addUserInfo(UserInfo userInfo) {

        log.info("用户详细信息为 ： " + userInfo);
        String date = DateUtils.Date2String(new Date(), "yyyy-MM-dd HH:ss");
        userInfo.setCreatetime(date);

        //System.out.println(userInfo);
        return userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public Integer updateUserFavor(String openId, String courseId) {
        LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserInfo::getOpenId, openId).set(UserInfo::getFavor, courseId);
        int update = userInfoMapper.update(null, updateWrapper);
        return update;
    }


    /**
     * 查找用户被收藏的ID
     *
     * @return
     */
    @Override
    public String[] findFavorId(String openId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("favor").eq("openID", openId);
        List<UserInfo> infos = userInfoMapper.selectList(queryWrapper);
        UserInfo userInfo = infos.get(0);
        String favors = userInfo.getFavor();
        if (StringUtils.isEmpty(favors)) {
            return null;
        }
        String[] faver = favors.split(",");
        return faver;
    }

    /**
     * 根据openId获取相应的历史浏览
     *
     * @param openId
     * @return
     */
    @Override
    public List<UserInfo> getHistoryByOpenId(String openId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openID", openId);
        queryWrapper.select("history");
        List<UserInfo> infos = userInfoMapper.selectList(queryWrapper);
        return infos;
    }


    /**
     * 更新历史浏览
     *
     * @param openId
     * @param courseId
     * @return
     */
    @Override
    public Integer addHistory(String openId, String courseId) {
        int update;
        String s;
        //历史浏览记录需要先获取，再添加
        List<UserInfo> historyInfo = this.getHistoryByOpenId(openId);
        if (StringUtils.isEmpty(historyInfo.get(0).getHistory())) {
            //说明没有历史浏览
            ArrayList<String> list = new ArrayList<>();
            list.add(courseId);
            //将list转化为字符串
            s = List2Str.list2Str(list, ',');
            //更新进去
            LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(UserInfo::getOpenId, openId).set(UserInfo::getHistory, s);
            update = userInfoMapper.update(null, updateWrapper);
        } else {
            UserInfo userInfo = historyInfo.get(0);
            String historyString = userInfo.getHistory();

            String[] split = historyString.split(",");
            //观察是否有该记录
            for (String s1 : split) {
                if (courseId.equals(s1)) {
                    return 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            //进行拼接
            for (String s1 : split) {
                sb.append(s1).append(",");
            }
            sb.append(courseId);

            //更新进去
            LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(UserInfo::getOpenId, openId).set(UserInfo::getHistory, sb.toString());
            update = userInfoMapper.update(null, updateWrapper);

        }
        return update;
    }

    /**
     * 根据ID删除记录
     *
     * @param openId
     * @param courseId
     * @return
     */
    @Override
    public Integer deleteHistoryByCourseId(String openId, String courseId) {
        //先获取，再删除，添加
        List<UserInfo> historyInfo = this.getHistoryByOpenId(openId);
        UserInfo userInfo = historyInfo.get(0);
        String historyString = userInfo.getHistory();

        String[] split = historyString.split(",");

        ArrayList<String> list = new ArrayList<>();

        for (String s : split) {
            if (!s.equals(courseId)) {
                list.add(s);
            }
        }
        String s = List2Str.list2Str(list, ',');
        //更新进去
        LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserInfo::getOpenId, openId).set(UserInfo::getHistory, s);
        int update = userInfoMapper.update(null, updateWrapper);

        return update;
    }

    /**
     * 根据用户openId获取历史浏览ID集
     *
     * @param openId
     * @return
     */
    @Override
    public String[] findHistoryIdsByOpenId(String openId) {
        LambdaQueryWrapper<UserInfo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserInfo::getOpenId, openId);
        queryWrapper.select(UserInfo::getHistory);

        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        UserInfo userInfo = userInfos.get(0);
        if (StringUtils.isEmpty(userInfo.getHistory())) {
            return null;
        }
        String[] split = userInfo.getHistory().split(",");

        return split;
    }

    /**
     * 删除所有历史浏览记录
     *
     * @param openId
     * @return
     */
    @Override
    public Integer deleteAllHistoryByOpenId(String openId) {
        LambdaUpdateWrapper<UserInfo> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(UserInfo::getOpenId, openId).set(UserInfo::getHistory, "");
        int update = userInfoMapper.update(null, updateWrapper);
        return update;
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        List<UserInfo> userInfos = userInfoMapper.selectList(new QueryWrapper<UserInfo>());

        for (UserInfo userInfo : userInfos) {
            ArrayList<String> favorList = new ArrayList<>();
            ArrayList<String> historyList = new ArrayList<>();
            //收藏课程ID
            String favor = userInfo.getFavor();
            if (!StringUtils.isEmpty(favor)) {
                String[] split = favor.split(",");
                for (String s : split) {
                    AllStudyCourse course = studyCourseService.findCourseById(s);
                    favorList.add(course.getTitle());
                }
            }
            // 收藏历史
            String history = userInfo.getHistory();
            if (!StringUtils.isEmpty(history)) {
                String[] split1 = history.split(",");
                for (String s : split1) {
                    AllStudyCourse courseById = studyCourseService.findCourseById(s);
                    historyList.add(courseById.getTitle());
                }
            }
            userInfo.setFavorCourseName(favorList);
            userInfo.setHistoryCourseName(historyList);
        }

        return userInfos;
    }

    @Override
    public Integer deleteUserByOpenId(String id) {
        return userInfoMapper.deleteById(id);
    }
}
