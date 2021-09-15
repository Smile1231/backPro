package com.zys.controller;

import com.zys.exception.APIException;
import com.zys.pojo.num.ResultCode;
import com.zys.pojo.po.AllCourseList;
import com.zys.pojo.po.UserInfo;
import com.zys.pojo.vo.ResultVO;
import com.zys.service.impl.StudyCourseServiceImpl;
import com.zys.service.impl.UserInfoServiceImpl;
import com.zys.utils.GetOpenIdUtils;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author cy
 * @create 2021-03-08-2:50 下午
 * @Description 关于访问用户的信息controller层
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/userInfo")
@Api(value = "微信用户相关接口")
public class UserInfoController {

    @Autowired
    private GetOpenIdUtils openIdUtils;

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Autowired
    private StudyCourseServiceImpl studyCourseService;


    /**
     * 获取 OpenId 接口
     *
     * @param jsCode
     * @return
     * @throws IOException
     */
    @GetMapping("/getOpenId")
    @ApiOperation("将OpenId加入到数据中")
    public String getUserOpenId(@RequestParam("code") String jsCode) throws IOException {

        String openId = openIdUtils.getUserInfo(jsCode);
        //将openid 存入到数据库之中
        if (!StringUtils.isEmpty(openId)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setOpenId(openId);
            Integer integer = userInfoService.addUser(userInfo);
            //System.out.println(integer);
//            0 --- 插入成功 1----插入失败 2----已经有该用户
            if (integer == 0) {
                log.info("获取用户openid成功且插入数据库成功");
            } else if (integer == 1) {
                log.info("插入失败");
            } else if (integer == 2) {
                log.info("已经拥有该用户");
            }
        }
        return openId;
    }

    /**
     * 用户点击授权按钮之后将基本信息存入数据库
     *
     * @param userInfo
     */
    @PostMapping("/saveUserInfo")
    @ApiOperation("用户点击授权之后，将完整信息存入数据库")
    public void saveUserInfo(@RequestBody UserInfo userInfo) {
        Integer integer = userInfoService.addUserInfo(userInfo);
        //如果返回值 大于 0 就说明发生了变化
        // log.info("更新操作受影响的行数为: "+integer);
    }

    @PostMapping("/updateFavor/{openID}/{courseId}")
    @ApiOperation("保存用户的收藏状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openID", value = "用户OpenID", required = true),
            @ApiImplicitParam(name = "courseId", value = "用户收藏的课程Id", required = true)
    })
    public ResultVO<Integer> updateFavor(@PathVariable("openID") String openID, @PathVariable("courseId") String courseId) {
        try {
            Integer integer = userInfoService.updateUserFavor(openID, courseId);
            return new ResultVO<Integer>(integer);
        } catch (Exception e) {
            throw new APIException(ResultCode.FAILED);
        }

    }

    @PostMapping("/findFavorIdsAndCourseDetails/{openId}")
    @ApiOperation("查询用户收藏的ID并找到相应的课程详情")
    public ResultVO<List> findFavorIdsAndCourseDetails(@PathVariable("openId") String openId) {
        try {
            String[] favorIds = userInfoService.findFavorId(openId);
            if (favorIds == null) {
                return new ResultVO<>(null);
            }
            List<AllCourseList> courseDetails = studyCourseService.findCourseByIds(favorIds);
            return new ResultVO<>(courseDetails);
        } catch (Exception e) {
            throw new APIException(ResultCode.FAILED);
        }
    }

    @PutMapping("/history/{openId}/{courseId}")
    @ApiOperation("根据openId添加用户的课程历史浏览courseId")
    public ResultVO<Integer> addHistory(@PathVariable("openId") String openId, @PathVariable("courseId") String courseId) {
        try {
            Integer integer = userInfoService.addHistory(openId, courseId);
            return new ResultVO<>(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVO<>(ResultCode.ERROR, null);
    }

    @DeleteMapping("/history/{openId}/{courseId}")
    @ApiOperation("根据openId删除用户的课程历史浏览courseId")
    public ResultVO<Integer> deleteHistory(@PathVariable("openId") String openId, @PathVariable("courseId") String courseId) {
        try {
            Integer integer = userInfoService.deleteHistoryByCourseId(openId, courseId);
            return new ResultVO<>(integer);
        } catch (Exception e) {
            throw new APIException(ResultCode.FAILED);
        }
    }

    @PostMapping("/history/{openId}")
    @ApiOperation("根据openId获取用户浏览历史并返回历史详情")
    public ResultVO<List> getHistoryByOpenId(@PathVariable("openId") String openId) {
        String[] historyIds = userInfoService.findHistoryIdsByOpenId(openId);
        if (historyIds == null) {
            return new ResultVO<>(null);
        }
        try {
            List<AllCourseList> historyCourseDetails = studyCourseService.findCourseByIds(historyIds);

            return new ResultVO<List>(historyCourseDetails);
        } catch (Exception e) {
            throw new APIException(ResultCode.ERROR);
        }
    }


    @DeleteMapping("/history/deleteAllHistory/{openId}")
    @ApiOperation("根据openId删除所有历史浏览记录")
    public ResultVO<Integer> deleteAllHistoryByOpenId(@PathVariable("openId") String openId) {
        Integer integer = userInfoService.deleteAllHistoryByOpenId(openId);

        return new ResultVO<>(integer);
    }

    @GetMapping("/userInfo")
    public ResultVO<List<UserInfo>> getAllUserInfo() {
        List<UserInfo> allUserInfo = userInfoService.getAllUserInfo();

        return new ResultVO<>(allUserInfo);
    }

    @DeleteMapping("/userInfo/{id}")
    public ResultVO<UserInfo> deleteUserByOpenId(@PathVariable("id") String id) {
        Integer integer = userInfoService.deleteUserByOpenId(id);

        if (integer == 1) {
            return new ResultVO<>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }


}
