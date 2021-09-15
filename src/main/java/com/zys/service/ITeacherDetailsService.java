package com.zys.service;

import com.zys.pojo.po.HotTeacher;
import com.zys.pojo.po.TeacherDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author cy
 * @create 2021-03-14-9:13 下午
 * @Description
 */
public interface ITeacherDetailsService {

    Integer uploadTeacherDetails(MultipartFile teacherImage, TeacherDetails teacherDetails) throws Exception;

    List<HotTeacher> findHotTeacher();

    TeacherDetails findTeacherById(String teacherId);

    List<TeacherDetails> findAllTeacher();

    Integer addTeacherDetails(TeacherDetails teacherDetails);

    Integer updateTeacherById(TeacherDetails teacherDetails);

    Integer updateDetailsById(TeacherDetails teacherDetails);

    Integer removeTeacherById(String id);

}
