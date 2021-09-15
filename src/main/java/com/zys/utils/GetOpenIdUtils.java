package com.zys.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * @author cy
 * @create 2021-03-08-10:06 上午
 * @Description 获取openid 工具了类
 */
@Component
@Slf4j
public class GetOpenIdUtils {
    private String url = "https://api.weixin.qq.com/sns/jscode2session";
    String res = "";

    public String getUserInfo(String jsCode) throws IOException {

        //log.info("jsCode为" + jsCode);

        //开始拼接参数
        url += "?appid=wxe74a69a6d8342c51";
        url += "&secret=dc25a12fed16dc7fa296dae381f74f48";
        url += "&js_code=" + jsCode;
        url += "&grant_type=authorization_code";

        log.info("解析code请求参数: " + url);
        // DefaultHttpClient();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //Get请求方式
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = null;

        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()          // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)                    // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)             // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)                    // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(false).build();           // 将上面的配置信息 运用到这个Get请求里
        httpGet.setConfig(requestConfig);                         // 由客户端执行(发送)Get请求
        response = httpClient.execute(httpGet);                   // 从响应模型中获取响应实体

        HttpEntity responseEntity = response.getEntity();
        //System.out.println("响应状态为:" + response.getStatusLine());
        if (responseEntity != null) {
            res = EntityUtils.toString(responseEntity);
            //System.out.println("响应内容长度为:" + responseEntity.getContentLength());
            System.out.println("响应内容为:" + res);
        }
        // 释放资源
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
        JSONObject jsonObject = JSON.parseObject(res);
        // System.out.println("返回的json为 : "+jsonObject);
        String openid = jsonObject.getString("openid");
        //System.out.println("openid" + openid);
        return openid;

    }


}
