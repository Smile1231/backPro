package com.zys.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author cy
 * @create 2021-03-13-1:28 下午
 * @Description 关于图片url 的拼接
 */
@Slf4j
@Component
public class GetLocalhostURLUtils {

    @Autowired
    private Environment environment;


    public String splicingURL(String url) {

        String allPath = "";

        //获取当前IP
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();

            //获取当前端口
            String port = environment.getProperty("server.port");
            //获取当前项目路径
            // String path = System.getProperty("user.dir");

            allPath = "http://" + "localhost" + ":" + port + "/upload" + url;

        } catch (UnknownHostException e) {
            log.info("无法获取IP");
            e.printStackTrace();
        }

        return allPath;
    }
}
