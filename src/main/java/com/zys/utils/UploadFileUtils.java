package com.zys.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author cy
 * @create 2021-03-13-3:46 下午
 * @Description 文件上传工具类
 */
@Slf4j
@Component
public class UploadFileUtils {

    @Autowired
    private GetLocalhostURLUtils getLocalhostURLUtils;


    /**
     * @param multipartFile 上传文件
     * @param path          上传路径
     * @return 0---上传失败   1-----上传成功
     */
    public Map uploadFile(MultipartFile multipartFile, String path) throws Exception {


        if (multipartFile.isEmpty()) {
            throw new Exception("上传文件为空");
        }

        log.info("文件名: " + multipartFile.getOriginalFilename());

        HashMap<String, String> map = new HashMap<>();

        //拓展名
        String fileSuffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        log.info("拓展名为 ： " + fileSuffix);

        //生成上传文件的名称

        String fileName = System.currentTimeMillis() + fileSuffix;

        log.info("文件名为 ： " + fileName);

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/upload" + path + "/" + fileName);

        //返回访问URL
        String url = getLocalhostURLUtils.splicingURL(path + "/" + fileName);

        log.info("URl为： " + url);

        //调用service层

        //判断文件是否存在
        if (!file.exists()) file.mkdirs();

        //上传
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code", "0");
            return map;
        }
        map.put("code", "1");
        map.put("fileName", fileName);
        map.put("url", url);
        return map;
    }
}
