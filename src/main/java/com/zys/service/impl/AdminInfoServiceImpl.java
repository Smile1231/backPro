package com.zys.service.impl;


import com.zys.dao.IAdminInfoMapper;
import com.zys.pojo.vo.ResponseInfo;
import com.zys.service.IAdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * @author cy
 * @create 2021-02-04-3:04 下午
 * @Description
 */
@Service
public class AdminInfoServiceImpl implements IAdminInfoService {

    @Autowired
    private IAdminInfoMapper adminInfoMapper;

    @Override
    public ResponseInfo loadAdminInfoByUsername(String username) {
        return null;
    }

    /**
     *
     * 该类实现了UserDetailsService 并重写该方法
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //获取 管理员的详细信息
//        AdminInfo adminInfo = adminInfoMapper.findAllByUsername(username);
//        if(adminInfo == null){
//            throw new UsernameNotFoundException("管理员账号不存在！");
//        }
//        //定义权限表
//        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
//        for(RoleInfo role: adminInfo.getRoles()){
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRName()));
//        }
//        User userDetails = new User(adminInfo.getUsername(), adminInfo.getPassword(), authorities);
//        return userDetails;
//    }
}
