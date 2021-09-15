package com.zys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zys.dao.IHotTeacherMapper;
import com.zys.dao.ITeacherDetailsMapper;
import com.zys.pojo.po.HotTeacher;
import com.zys.pojo.po.TeacherDetails;
import com.zys.service.ITeacherDetailsService;
import com.zys.utils.DateUtils;
import com.zys.utils.NowTime;
import com.zys.utils.UploadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @create 2021-03-14-9:14 下午
 * @Description
 */
@Slf4j
@Service
public class TeacherDetailsServiceImpl implements ITeacherDetailsService {

    @Autowired
    private UploadFileUtils uploadFileUtils;
    @Autowired
    private ITeacherDetailsMapper teacherDetailsMapper;

    @Autowired
    private IHotTeacherMapper hotTeacherMapper;

    /**
     * @param teacherDetails
     * @return 返回1插入成功 ， 插入 0 则失败
     */
    @Override
    public Integer uploadTeacherDetails(MultipartFile teacherImage, TeacherDetails teacherDetails) throws Exception {

        Map map = uploadFileUtils.uploadFile(teacherImage, "/teacher");
        boolean res = (map.get("code") == "1");
        if (res) {
            teacherDetails.setTeacherImageUrlPath((String) map.get("url"));
            teacherDetails.setUploadtime(NowTime.getNowTime());
            int i = teacherDetailsMapper.insert(teacherDetails);
            return i;
        }

        return 0;

    }

    @Override
    public List<HotTeacher> findHotTeacher() {
        QueryWrapper<HotTeacher> queryWrapper = new QueryWrapper<>();
        List<HotTeacher> hotTeachers = hotTeacherMapper.selectList(queryWrapper);
        return hotTeachers;
    }

    /**
     * 根据id获取教师
     *
     * @return
     */
    @Override
    public TeacherDetails findTeacherById(String teacherId) {
        TeacherDetails teacherDetails = teacherDetailsMapper.selectById(teacherId);
        return teacherDetails;
    }


    @Override
    public List<TeacherDetails> findAllTeacher() {
        List<TeacherDetails> teacherDetailsList = teacherDetailsMapper.selectList(new QueryWrapper<TeacherDetails>());
        // log.info(teacherDetailsList.toString());
        for (TeacherDetails teacherDetails : teacherDetailsList) {
            if (teacherDetails.getHotOrNot() == 1) {
                teacherDetails.setHotOrNotState(true);
            } else teacherDetails.setHotOrNotState(false);
        }
        return teacherDetailsList;
    }

    @Override
    public Integer addTeacherDetails(TeacherDetails teacherDetails) {
        teacherDetails.setUploadtime(NowTime.getNowTime());
        return teacherDetailsMapper.insert(teacherDetails);
    }

    @Override
    public Integer updateTeacherById(TeacherDetails teacherDetails) {
        UpdateWrapper<TeacherDetails> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("ID", teacherDetails.getId()).set("hotOrNot", teacherDetails.getHotOrNot());
        return teacherDetailsMapper.update(null, updateWrapper);
    }

    @Override
    public Integer updateDetailsById(TeacherDetails teacherDetails) {
        UpdateWrapper<TeacherDetails> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("ID", teacherDetails.getId()).set("teacherName", teacherDetails.getTeacherName()).set("teacherSchool", teacherDetails.getTeacherSchool()).set("teacherDescription", teacherDetails.getTeacherDescription());
        return teacherDetailsMapper.update(null, updateWrapper);
    }

    @Override
    public Integer removeTeacherById(String id) {
        return teacherDetailsMapper.deleteById(id);
    }
}
