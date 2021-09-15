package com.zys.controller;

import com.zys.exception.APIException;
import com.zys.pojo.num.ResultCode;
import com.zys.pojo.po.AllStudyCourse;
import com.zys.pojo.po.HotTeacher;
import com.zys.pojo.po.TeacherDetails;
import com.zys.pojo.vo.ResultVO;
import com.zys.service.impl.TeacherDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author cy
 * @create 2021-03-14-9:17 下午
 * @Description
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherDetailsController {

    @Autowired
    private TeacherDetailsServiceImpl teacherDetailsService;

    @PostMapping("/addTeacherDetails")
    public ResultVO<TeacherDetails> uploadTeacherDetails(MultipartFile teacherImage, TeacherDetails teacherDetails) throws Exception {
        if (teacherDetails == null || teacherImage == null) {
            throw new APIException(ResultCode.VALIDATE_FAILED);
        }
        Integer integer = teacherDetailsService.uploadTeacherDetails(teacherImage, teacherDetails);
        if (integer == 1) {
            return new ResultVO<TeacherDetails>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @GetMapping("/findHotTeacher")
    public ResultVO<List> findHotTeacher() {
        try {
            List<HotTeacher> hotTeachers = teacherDetailsService.findHotTeacher();

            return new ResultVO<List>(hotTeachers);
        } catch (Exception e) {
            throw new APIException(ResultCode.ERROR);
        }
    }


    @PostMapping("/findByTeacherId/{teacherId}")
    @ApiOperation(("根据ID获取教师详情"))
    public ResultVO<TeacherDetails> findByTeacherId(@PathVariable("teacherId") String teacherId) {

        try {
            TeacherDetails teacherDetails = teacherDetailsService.findTeacherById(teacherId);
            return new ResultVO<TeacherDetails>(teacherDetails);
        } catch (Exception e) {
            throw new APIException(ResultCode.ERROR);
        }
    }

    @GetMapping("/findAllTeacher")
    @ApiOperation("获取所有的教师")
    public ResultVO<List<TeacherDetails>> findAllTeacher() {
        try {
            List<TeacherDetails> allTeacher = teacherDetailsService.findAllTeacher();

            return new ResultVO<List<TeacherDetails>>(allTeacher);
        } catch (Exception e) {
            throw new APIException(ResultCode.FAILED);
        }
    }

    @PutMapping("/teacher")
    public ResultVO<TeacherDetails> addTeacher(@RequestBody TeacherDetails teacherDetails) {
        //log.info(teacherDetails.toString());
        Integer integer = teacherDetailsService.addTeacherDetails(teacherDetails);
        if (integer == 1) {
            return new ResultVO<>(null);
        }
        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @PostMapping("/teacher/hot")
    public ResultVO<TeacherDetails> updateHotById(@RequestBody TeacherDetails teacherDetails) {
        // log.info(teacherDetails.toString());
        Integer integer = teacherDetailsService.updateTeacherById(teacherDetails);
        if (integer == 1) {
            return new ResultVO<>(null);
        }
        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @PostMapping("/teacher/details")
    public ResultVO<TeacherDetails> updateDetailsById(@RequestBody TeacherDetails teacherDetails) {
        //log.info(teacherDetails.toString());
        Integer integer = teacherDetailsService.updateDetailsById(teacherDetails);
        if (integer == 1) {
            return new ResultVO<>(null);
        }
        return new ResultVO<>(ResultCode.FAILED, null);
    }


    @PostMapping("/teacher/remove/{id}")
    public ResultVO<TeacherDetails> removeTeacherById(@PathVariable("id") String id) {
        Integer integer = teacherDetailsService.removeTeacherById(id);
        if (integer > 0) {
            return new ResultVO<>(null);
        }
        return new ResultVO<>(ResultCode.FAILED, null);
    }


}
