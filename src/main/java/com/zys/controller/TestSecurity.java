package com.zys.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zys.pojo.base.UsersResponse;
import com.zys.pojo.vo.GetMenus;
import com.zys.pojo.vo.GetRights;
import com.zys.pojo.vo.Users;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @create 2021-02-04-11:39 上午
 * @Description
 */
@RestController
@CrossOrigin
public class TestSecurity {

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/helloAdmin")
    public String helloAdmin() {
        return "I am Admin";
    }

    @GetMapping("/helloUser")
    public String helloUser() {
        return "I am User";
    }


    /**
     * 测试登陆测试，跨域
     *
     * @param map
     * @return
     */
    @PostMapping("/login")
    public String testLogin(@RequestBody Map map) {
        return "login sucess------" + map.get("username") + " ---- ";
    }

    @GetMapping("/getMenus")
    public Object getMenuList() {
//        {
//            "data":
//            {
//                    "id": 101,
//                    "authName": "商品管理",
//                    "path": null,
//                    "children": [
//                {
//                        "id": 104,
//                        "authName": "商品列表",
//                        "path": null,
//                        "children": []
//                }
//            ]
//            }
//            "meta": {
//            "msg": "获取菜单列表成功",
//                    "status": 200
//             }
//        }
        ArrayList<GetMenus> list = new ArrayList<>();
        ArrayList<GetMenus> list11 = new ArrayList<>();
        ArrayList<GetMenus> list2 = new ArrayList<>();
        ArrayList<GetMenus> list3 = new ArrayList<>();
        ArrayList<GetMenus> list4 = new ArrayList<>();
        ArrayList<GetMenus> list5 = new ArrayList<>();
        ArrayList<GetMenus> list6 = new ArrayList<>();
        ArrayList<Object> list1 = new ArrayList<>();
        list.add(new GetMenus(111, "用户列表", "users", null));
        list11.add(new GetMenus(112, "角色列表", "roles", null));
        list11.add(new GetMenus(113, "权限列表", "rights", null));
        list2.add(new GetMenus(114, "商品列表", "goods", null));
        list2.add(new GetMenus(115, "商品参数", "goodsDetails", null));
        list2.add(new GetMenus(116, "商品分类", "category", null));
        list3.add(new GetMenus(117, "课程详情列表", "course", null));
        list4.add(new GetMenus(118, "数据报表", "reports", null));
        list5.add(new GetMenus(119, "教师列表详情", "teachers", null));
        list6.add(new GetMenus(120, "轮播图列表详情", "swiperItems", null));

        GetMenus getMenus1 = new GetMenus(101, "用户管理", null, list);
        GetMenus getMenus2 = new GetMenus(102, "权限管理", null, list11);
        GetMenus getMenus3 = new GetMenus(103, "商品管理", null, list2);
        GetMenus getMenus4 = new GetMenus(104, "课程管理", null, list3);
        GetMenus getMenus5 = new GetMenus(105, "数据统计", null, list4);
        GetMenus getMenus6 = new GetMenus(106, "教师管理", null, list5);
        GetMenus getMenus7 = new GetMenus(107, "轮播图管理", null, list6);
        list1.add(getMenus1);
        // list1.add(getMenus2);
        // list1.add(getMenus3);
        list1.add(getMenus4);

        list1.add(getMenus6);
        list1.add(getMenus7);
        //list1.add(getMenus5);


        return list1;
    }

    @GetMapping("/users")
    public Object getUsers(String query, double pagenum, double pagesize) {
        Users users = new Users(25, "cy", "110", 1, "992774731@qq.com", "2021-2-18 ", true, "炒鸡管理员");
        ArrayList<Users> list = new ArrayList<>();
        list.add(users);
        list.add(users);
        list.add(users);

        UsersResponse res = new UsersResponse(Math.ceil(3 / pagesize), pagenum, list);
        return res;
    }

    @PutMapping("/users/{id}/{mg_state}")
    public Object updateSwitch(@PathVariable("id") Integer id, @PathVariable("mg_state") boolean state) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("id", id);
        map.put("mg_state", state);

        return map;
    }


    @GetMapping("/getRights")
    public Object getRights() {
        ArrayList<GetRights> rights = new ArrayList<>();
        rights.add(new GetRights(101, "商品管理", "0", "0", "goods"));
        rights.add(new GetRights(102, "订单管理", "0", "0", "orders"));
        rights.add(new GetRights(103, "权限管理", "0", "0", "rights"));
        rights.add(new GetRights(104, "商品列表", "1", "0", "goods"));
        rights.add(new GetRights(105, "添加商品", "1", "0", "goods"));
        rights.add(new GetRights(106, "订单管理", "1", "0", "orders"));
        rights.add(new GetRights(107, "添加订单", "1", "0", "orders"));
        rights.add(new GetRights(108, "用户列表", "1", "0", "users"));
        rights.add(new GetRights(109, "角色列表", "2", "0", "roles"));
        rights.add(new GetRights(110, "权限列表", "2", "0", "rights"));
        rights.add(new GetRights(111, "分类参数", "2", "0", "category"));

        return rights;
    }
}


