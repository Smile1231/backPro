package com.zys;

import com.zys.dao.IAdminInfoMapper;
import com.zys.dao.IRoleInfoMapper;
import com.zys.dao.IUserInfoMapper;
import com.zys.pojo.po.AdminInfo;
import com.zys.pojo.po.UserInfo;
import com.zys.service.IAdminInfoService;
import com.zys.service.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MiniProgrammeApplicationTests {

    @Autowired
    private IUserInfoMapper IUserInfoMapper;

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Autowired
    private IAdminInfoService adminInfoService;

    @Autowired
    private IAdminInfoMapper adminInfoMapper;


    @Autowired
    private IRoleInfoMapper roleInfoMapper;


//    @Test
//    void contextLoads() {
//        UserInfo userInfo = new UserInfo("116", "名字", "男", "美国", "洛杉矶", "泰兴", "。。。", null,null,null,null);
//        Integer integer = IUserInfoMapper.addUser(userInfo);
//        System.out.println("返回结果："+ integer);
//    }
//
//    @Test
//    void testAddUser(){
//        UserInfo userInfo = new UserInfo("117", "名字", "男", "美国", "洛杉矶", "泰兴", "。。。", null,null,null,null);
//        Integer integer = userInfoService.addUser(userInfo);
//        System.out.println("返回："+ integer);
//    }


    /**
     * 测试根据username 获取角色信息
     *
     * @param
     */
    @Test
    void testGetAdminByName() {
        AdminInfo adminInfo = adminInfoMapper.findAllByUsername("root");
        System.out.println(adminInfo);
    }

    @Test
    void testAddAdminInfo() {
        Integer roleId = roleInfoMapper.findRoleIdByRoleName("管理员");
        // Integer roleId = roleInfoMapper.findRoleIdByRoleName("普通");
        // Integer integer = adminInfoMapper.addAdmin("root", passwordEncoder.encode("root"), roleId);
        // System.out.println("返回的结果："+ integer);
    }

}
