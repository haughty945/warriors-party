package com.mine.warriorsserveresayexcel.web;

import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsservercommon.utils.ExcelUtil;
import com.mine.warriorsservercommon.utils.ResultVOUtil;
import com.mine.warriorsserveresayexcel.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: warriors-party
 * @description:
 * @author: Mine.Lee
 * @create: 2019-02-27 10:39
 * @version: v1.0
 * @remark: ..
 */
@RestController
@Slf4j
public class ExcelController {

    @RequestMapping(value = "/exportExcel",method = RequestMethod.GET)
    public ResultVO<?> exportExcel(HttpServletRequest request, HttpServletResponse response) {
        List<User> datas = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                User user = new User("姓名" + i,"男" + i,new Date());
                datas.add(user);
            }
            ExcelUtil.ExportExcel(response,datas,"测试user");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.returnSuccess();
    }

    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public ResultVO<?> importExcel(@RequestParam("file") MultipartFile file) {
        try {
            List<User> list = (List<User>) ExcelUtil.importExcel(file, User.class);
            if (list != null || list.size() > 0) {
                for (User user : list) {
                    System.out.println(user);
                }
            } else {
                return ResultVOUtil.returnFail(400, "数据不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultVOUtil.returnSuccess();
    }
}
