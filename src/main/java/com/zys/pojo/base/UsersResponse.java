package com.zys.pojo.base;

import com.zys.pojo.vo.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author cy
 * @create 2021-02-18-11:08 上午
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponse implements Serializable {
    private double totalpage;
    private double pagenum;
    private List<Users> users;
}
