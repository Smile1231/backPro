package com.zys.controller;

import com.zys.pojo.num.ResultCode;
import com.zys.pojo.po.SwiperItems;
import com.zys.pojo.po.TeacherDetails;
import com.zys.pojo.vo.ResultVO;
import com.zys.service.impl.SwiperItemsServiceImpl;
import com.zys.utils.GetLocalhostURLUtils;
import com.zys.utils.UploadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @create 2021-03-09-4:59 下午
 * @Description
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/swiperItems")
public class SwiperItemsController {

    @Autowired
    private SwiperItemsServiceImpl swiperItemsService;

    @Autowired
    private GetLocalhostURLUtils getLocalhostURLUtils;

    @Autowired
    private UploadFileUtils uploadFileUtils;


    @PostMapping("/uploadSwiperItems")
    public ResultVO uploadSwiperItems(MultipartFile multipartFile) throws Exception {
        Map map = uploadFileUtils.uploadFile(multipartFile, "/swiper");
        boolean res = (map.get("code") == "1");
        if (res) {
            SwiperItems swiperItems = new SwiperItems();
            swiperItems.setImageName((String) map.get("fileName"));
            swiperItems.setImageUrlPath((String) map.get("url"));
            Integer integer = swiperItemsService.uploadSwiperItems(swiperItems);
            //System.out.println(integer);
            if (integer == 1) {
                return new ResultVO<SwiperItems>(swiperItems);
            }
        }
        return new ResultVO<SwiperItems>(ResultCode.ERROR, null);
    }

    /**
     * 返回轮播图接口
     *
     * @return
     */
    @GetMapping("/getSwiperItems")
    public List getSwiperItems() {
        List swiperItems = swiperItemsService.getSwiperItems();
        return swiperItems;
    }

//    @GetMapping("/testURl")
//    public String getURL(){
//        return getLocalhostURLUtils.splicingURL("");
//    }

    @GetMapping("/swiperItems")
    public ResultVO<List<SwiperItems>> getSwiperItemsAdmin() {

        try {
            List<SwiperItems> allSwiperItems = swiperItemsService.getAllSwiperItems();

            return new ResultVO<List<SwiperItems>>(allSwiperItems);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @PutMapping("/swiperItems")
    public ResultVO<TeacherDetails> addSwiperItems(@RequestBody SwiperItems swiperItems) {
        //log.info(swiperItems.toString());
        Integer integer = swiperItemsService.uploadSwiperItems(swiperItems);

        if (integer == 1) {
            return new ResultVO<>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }

    @DeleteMapping("/swiperItems/{id}")
    public ResultVO<SwiperItems> deleteSwiperById(@PathVariable("id") String id) {
        Integer integer = swiperItemsService.deleteSwiperById(id);
        if (integer == 1) {
            return new ResultVO<>(null);
        }

        return new ResultVO<>(ResultCode.FAILED, null);
    }


}
