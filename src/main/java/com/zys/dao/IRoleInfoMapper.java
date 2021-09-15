package com.zys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zys.pojo.po.RoleInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cy
 * @create 2021-02-04-2:07 下午
 * @Description 操作RoleInfo 的映射接口
 */
@Repository
public interface IRoleInfoMapper extends BaseMapper<RoleInfo> {

    @Select("select * from RoleInfo where rid = #{rid}")
    List<RoleInfo> findRoleInfosByRid(String rid);

    @Select("select rid from RoleInfo where r_description = #{roleName}")
    Integer findRoleIdByRoleName(String roleName);

}
