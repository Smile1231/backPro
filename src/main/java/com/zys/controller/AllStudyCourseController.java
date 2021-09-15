package com.zys.controller;


import com.zys.exception.APIException;
import com.zys.pojo.num.ResultCode;
import com.zys.pojo.po.AllCourseList;
import com.zys.pojo.po.AllStudyCourse;
import com.zys.pojo.vo.ResultVO;
import com.zys.service.impl.StudyCourseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author cy
 * @create 2021-03-14-5:50 下午
 * @Description 关于学习资料的controller
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/studyCourse")
@Api(tags = "课程相关接口")
public class AllStudyCourseController {

    @Autowired
    private StudyCourseServiceImpl studyCourseService;


    /**
     * 上传资料操作
     *
     * @param picFile
     * @param videoFile
     * @param allStudyCourse
     * @return
     * @throws Exception
     */
    @ApiOperation("上传资料操作")
    @PostMapping("/uploadStudyCourse")
    public ResultVO<AllStudyCourse> uploadStudyCourse(MultipartFile picFile, MultipartFile videoFile, AllStudyCourse allStudyCourse) throws Exception {
        Integer integer = studyCourseService.uploadStudyCourse(picFile, videoFile, allStudyCourse);
        // 如果integer 为1 ， 插入成功 ， 0---为失败
        if (integer == 1) {
            return new ResultVO<>(null);
        }
        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @ApiOperation("根据状态码查找课程列表")
    @PostMapping("/findCourseList")
    public ResultVO<List<AllCourseList>> findAllCourseList(@RequestBody String courseState) {
        // 0 -- 即将开课
        // 1 -- 已经开课
        // 2 -- 已结课
        // log.info(String.valueOf(courseState));
        try {
            List<AllCourseList> allCourse = studyCourseService.findAllCourse(courseState);
            return new ResultVO<List<AllCourseList>>(allCourse);
        } catch (Exception e) {
            throw new APIException(ResultCode.ERROR);
        }

    }

    @PostMapping("/getCourseById/{courseId}")
    @ApiOperation("根据ID获取课程详情")
    public ResultVO<AllStudyCourse> findCourseById(@PathVariable("courseId") String courseId) {
        try {
            AllStudyCourse course = studyCourseService.findCourseById(courseId);

            return new ResultVO<AllStudyCourse>(course);
        } catch (Exception e) {
            throw new APIException(ResultCode.ERROR);
        }

    }

    @PostMapping("/updateFavor/{courseId}/{favorOrNot}")
    @ApiOperation("更新用户的收藏动作")
    public ResultVO<Integer> updateFavor(@PathVariable("courseId") String courseId, @PathVariable("favorOrNot") String favorOrNot) {
        try {
            if ("1".equals(favorOrNot)) {
                System.out.println(studyCourseService.updateFavorById(courseId, "0"));
            } else {
                System.out.println(studyCourseService.updateFavorById(courseId, "1"));
            }
        } catch (Exception e) {
            throw new APIException(ResultCode.ERROR);
        }

        return new ResultVO<Integer>(1);
    }

    @GetMapping("/AllStudyCourse")
    @ApiOperation("后台获取所有课程详细资料")
    public ResultVO<List<AllStudyCourse>> getAllStudyCourses() {
        List<AllStudyCourse> allCourseDetails = studyCourseService.getAllCourseDetails();

        return new ResultVO<>(allCourseDetails);
    }


    @PutMapping("/studyCourse")
    public ResultVO<AllStudyCourse> addStudyCourse(@RequestBody(required = false) AllStudyCourse studyCourse) {
        // log.info(studyCourse.toString());
        Integer integer = studyCourseService.addStudyCourse(studyCourse);

        if (integer == 1) {
            return new ResultVO<>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @PostMapping("/studyCourse/hot")
    @ApiOperation("根据id更新是否热门")
    public ResultVO<AllStudyCourse> updateHotById(@RequestBody AllStudyCourse studyCourse) {

        Integer integer = studyCourseService.updateHotById(studyCourse);

        if (integer == 1) {
            return new ResultVO<>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @DeleteMapping("/studyCourse/{id}")
    public ResultVO<AllStudyCourse> deleteCourseById(@PathVariable("id") String id) {
        Integer integer = studyCourseService.deleteCourseById(id);

        if (integer == 1) {
            return new ResultVO<>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @PostMapping("/studyCourse/details")
    public ResultVO<AllStudyCourse> updateDetailsById(@RequestBody AllStudyCourse allStudyCourse) {
        Integer integer = studyCourseService.updateCourseDetailsById(allStudyCourse);

        if (integer == 1) {
            return new ResultVO<>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }
}
