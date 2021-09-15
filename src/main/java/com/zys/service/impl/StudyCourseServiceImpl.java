package com.zys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zys.dao.IAllCourseListMapper;
import com.zys.dao.IStudyCourseMapper;
import com.zys.pojo.po.AllCourseList;
import com.zys.pojo.po.AllStudyCourse;
import com.zys.pojo.po.TeacherDetails;
import com.zys.service.IStudyCourseService;
import com.zys.utils.DateUtils;
import com.zys.utils.NowTime;
import com.zys.utils.UploadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @create 2021-03-14-5:57 下午
 * @Description
 */
@Slf4j
@Service
public class StudyCourseServiceImpl implements IStudyCourseService {

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Autowired
    private IStudyCourseMapper uploadStudyCourseMapper;

    @Autowired
    private IAllCourseListMapper allCourseListMapper;

    @Autowired
    private IStudyCourseMapper studyCourseMapper;


    @Autowired
    private TeacherDetailsServiceImpl teacherDetailsService;

    @Override
    public Integer uploadStudyCourse(MultipartFile pic, MultipartFile video, AllStudyCourse allStudyCourse) throws Exception {

        //上传图片
        Map picMap = uploadFileUtils.uploadFile(pic, "/allStudyCourse/pic");
        boolean picRes = (picMap.get("code") == "1");//1说明上传成功
        Map videoMap = uploadFileUtils.uploadFile(video, "/allStudyCourse/video");
        boolean videoRes = videoMap.get("code") == "1"; //1上传视频成功
        if (picRes && videoRes) {
            String date = DateUtils.Date2String(new Date(), "yyyy-MM-dd HH:ss");
            allStudyCourse.setUploadtime(date);
            allStudyCourse.setCourseImageUrlPath((String) picMap.get("url"));
            allStudyCourse.setVideoUrlPath((String) videoMap.get("url"));

            log.info("传入的实体类为： " + allStudyCourse);
            //进行数据库插入操作  返回 1 为成功
            int i = uploadStudyCourseMapper.insert(allStudyCourse);
            return i;
        }
        return 0;
    }

    @Override
    public List<AllCourseList> findAllCourse(String courseState) {
        Map courseStateMap = (Map) JSONObject.parse(courseState);
        QueryWrapper<AllCourseList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("courseState", courseStateMap.get("courseState"));
        List<AllCourseList> courseLists = allCourseListMapper.selectList(queryWrapper);
        return courseLists;
    }

    /**
     * 根据id查找课程
     *
     * @param courseId
     * @return
     */
    @Override
    public AllStudyCourse findCourseById(String courseId) {
//        QueryWrapper<AllStudyCourse> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("ID", courseId);
        AllStudyCourse course = studyCourseMapper.selectById(courseId);

        return course;
    }

    /**
     * 更新收藏操作
     *
     * @param CourseId
     * @param favor
     * @return
     */
    @Override
    public Integer updateFavorById(String CourseId, String favor) {
        LambdaUpdateWrapper<AllStudyCourse> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(AllStudyCourse::getId, CourseId).set(AllStudyCourse::getFavorOrNot, favor);
        return studyCourseMapper.update(null, updateWrapper);
    }

    @Override
    public List<AllCourseList> findCourseByIds(String[] courseIds) {
        QueryWrapper<AllCourseList> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("ID", courseIds);
        List<AllCourseList> allCourseLists = allCourseListMapper.selectList(queryWrapper);
        return allCourseLists;
    }

    @Override
    public List<AllStudyCourse> getAllCourseDetails() {
        List<AllStudyCourse> studyCourses = studyCourseMapper.selectList(new QueryWrapper<AllStudyCourse>());
        //这边需要多做一步操作，就是需要设置课程老师的名字
        for (AllStudyCourse studyCourse : studyCourses) {
            String teacherId = String.valueOf(studyCourse.getRelatedTeacherId());
            TeacherDetails teacher = teacherDetailsService.findTeacherById(teacherId);
            studyCourse.setTeacherSchool(teacher.getTeacherSchool());
            studyCourse.setTeacherName(teacher.getTeacherName());
        }
        return studyCourses;
    }

    @Override
    public Integer addStudyCourse(AllStudyCourse allStudyCourse) {
        allStudyCourse.setUploadtime(NowTime.getNowTime());
        return studyCourseMapper.insert(allStudyCourse);
    }

    @Override
    public Integer updateHotById(AllStudyCourse allStudyCourse) {
        UpdateWrapper<AllStudyCourse> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("ID", allStudyCourse.getId()).set("hotOrNot", allStudyCourse.getHotOrNot());
        return studyCourseMapper.update(null, updateWrapper);
    }

    @Override
    public Integer deleteCourseById(String id) {
        return studyCourseMapper.deleteById(id);
    }

    @Override
    public Integer updateCourseDetailsById(AllStudyCourse allStudyCourse) {
        return studyCourseMapper.updateById(allStudyCourse);
    }
}
