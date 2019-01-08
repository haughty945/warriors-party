package com.mine.warriorsservermultisource.web;

import com.mine.warriorsservermultisource.entity.SysUser;
import com.mine.warriorsservermultisource.mapper.first.FirstSysUserMapper;
import com.mine.warriorsservermultisource.mapper.second.SecondSysUserMapper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : mine_lee
 * @Date : 2019-01-08
 * @Remark :【】控制层
 */
@Slf4j
@Api(tags = {"【】模块API"})
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private FirstSysUserMapper firstSysUserMapper;

    @Autowired
    private SecondSysUserMapper secondSysUserMapper;

    @RequestMapping(value = "/queryAll1", method = RequestMethod.POST)
    public Object deleteSysUser1() {
        return firstSysUserMapper.queryAll();
    }

    @RequestMapping(value = "/queryAll2", method = RequestMethod.POST)
    public Object deleteSysUser2() {
        return secondSysUserMapper.queryAll();
    }
}

