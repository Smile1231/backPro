package com.zys.service;

import com.zys.pojo.po.AllCourseList;
import com.zys.pojo.po.AllStudyCourse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author cy
 * @create 2021-03-14-5:56 下午
 * @Description 上传学习资料业务层
 */
public interface IStudyCourseService {

    Integer uploadStudyCourse(MultipartFile pic, MultipartFile video, AllStudyCourse allStudyCourse) throws Exception;

    List<AllCourseList> findAllCourse(String courseState);

    AllStudyCourse findCourseById(String courseId);

    Integer updateFavorById(String courseId, String favor);

    List<AllCourseList> findCourseByIds(String[] courseIds);

    List<AllStudyCourse> getAllCourseDetails();

    Integer addStudyCourse(AllStudyCourse allStudyCourse);

    Integer updateHotById(AllStudyCourse allStudyCourse);

    Integer deleteCourseById(String id);

    Integer updateCourseDetailsById(AllStudyCourse allStudyCourse);

}
