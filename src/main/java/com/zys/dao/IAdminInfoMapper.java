package com.zys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zys.pojo.po.AdminInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author cy
 * @create 2021-02-04-2:07 下午
 * @Description 操作 AdminInfo表的 映射接口
 */
@Repository
public interface IAdminInfoMapper extends BaseMapper<AdminInfo> {

    @Insert("insert into AdminInfo(username,password,role_id) values(#{username},#{password},#{roleId})")
    Integer addAdmin(String username, String password, Integer roleId);

    @Select("select * from AdminInfo where username = #{username} ")
    @Results({
            @Result(id = true, property = "id", column = "ID"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "createtime", column = "createtime"),
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roles", column = "role_id", javaType = List.class,
                    many = @Many(select = "com.zys.mapper.IRoleInfoMapper.findRoleInfosByRid", fetchType = FetchType.LAZY)
            )
    })
    AdminInfo findAllByUsername(String username);

    @Select("select * from AdminInfo where role_id = #{roleId}")
    AdminInfo findAdminInfosByRoleId(String roleId);


}
