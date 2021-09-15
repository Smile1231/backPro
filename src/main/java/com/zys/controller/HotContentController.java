package com.zys.controller;

import com.zys.exception.APIException;
import com.zys.pojo.num.ResultCode;
import com.zys.pojo.po.HotContent;
import com.zys.pojo.vo.ResultVO;
import com.zys.service.impl.HotContentServiceImpl;
import com.zys.utils.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @create 2021-03-14-3:17 下午
 * @Description
 */
@RestController
@RequestMapping("/studyCourse")
public class HotContentController {

    @Autowired
    private HotContentServiceImpl hotContentService;


    @GetMapping("/getHotContent")
    public Object getHotContent() {
        List<HotContent> hotContent;
        try {
            hotContent = hotContentService.getHotContent();
        } catch (Exception e) {
            return new APIException(ResultCode.ERROR);
        }
        return new ResultVO<List>(hotContent);
    }


}
