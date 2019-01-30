package com.mine.warriorsserverfile.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @program: warriors-party
 * @description: 文件上传
 * @author: Mine.Lee
 * @create: 2019-01-30 17:18
 * @version: v1.0
 * @remark: ..
 */
@Controller
public class FileUploadController {

    private String path = "D:/test";


    @RequestMapping("file")
    public String file() {
        return "/file";
    }

    @RequestMapping("multifile")
    public String multifile() {
        return "/multifile";
    }

    /**
     * 实现文件上传
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();
        Long size = file.getSize();
        System.out.println(fileName + "-->" + size + "kb");
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }



    /**
     * 实现多文件上传
     * public @ResponseBody String multifileUpload(@RequestParam("fileName")List<MultipartFile> files)
     */
    @RequestMapping(value = "multifileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String multifileUpload(HttpServletRequest request) {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");

        if (files.isEmpty()) {
            return "false";
        }
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);

            if (file.isEmpty()) {
                return "false";
            } else {
                File dest = new File(path + "/" + fileName);
                if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "false";
                }
            }
        }
        return "true";
    }
}
