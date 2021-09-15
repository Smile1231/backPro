package com.zys.controller.upload;

import com.zys.exception.APIException;
import com.zys.pojo.num.ResultCode;
import com.zys.pojo.vo.ResultVO;
import com.zys.pojo.vo.Upload;
import com.zys.utils.NowTime;
import com.zys.utils.UploadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author cy
 * @create 2021-04-19-9:48 上午
 * @Description
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadFileUtils fileUtils;

    @PostMapping("/uploadPicAction")
    public ResultVO<Upload> uploadPicAction(@RequestParam MultipartFile file) throws Exception {
        //对文件进行判空
        if (ObjectUtils.isEmpty(file)) throw new APIException(ResultCode.FAILED);

        Map map = fileUtils.uploadFile(file, "/picture");

        Upload upload = new Upload();

        boolean res = (map.get("code") == "1");
        if (res) {
            upload.setUrl((String) map.get("url"));
            upload.setName((String) map.get("fileName"));
            return new ResultVO<>(upload);
        }

        return new ResultVO<>(ResultCode.FAILED, null);

    }
}
