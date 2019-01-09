package com.mine.warriorsservermybatisplus.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsservermybatisplus.dto.SysUserDTO;
import com.mine.warriorsservermybatisplus.entity.SysUser;
import com.mine.warriorsservermybatisplus.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private ISysUserService iSysUserService;

    @ApiOperation(value = "列表查询", notes = "API")
    @RequestMapping(value = "/searchSysUserList", method = RequestMethod.POST)
    public ResultVO<List<SysUser>> searchSysUserList(@RequestBody SysUserDTO dto) {
        return (ResultVO<List<SysUser>>) iSysUserService.searchSysUserList(dto);
    }

    @ApiOperation(value = "列表分页查询", notes = "API")
    @RequestMapping(value = "/searchSysUserListPage", method = RequestMethod.POST)
    public ResultVO<Page<SysUser>> searchSysUserListPage(@RequestBody SysUserDTO dto) {
        return (ResultVO<Page<SysUser>>) iSysUserService.searchSysUserListPage(dto);
    }

    @ApiOperation(value = "详细查询", notes = "API")
    @RequestMapping(value = "/searchSysUserOne", method = RequestMethod.POST)
    public ResultVO<SysUser> searchSysUserOne(@RequestBody SysUserDTO dto) {
        return (ResultVO<SysUser>) iSysUserService.searchSysUserOne(dto);
    }

    @ApiOperation(value = "添加", notes = "API")
    @RequestMapping(value = "/addSysUser", method = RequestMethod.POST)
    public ResultVO<?> addSysUser(@RequestBody SysUserDTO dto) {
        return iSysUserService.addSysUser(dto);
    }

    @ApiOperation(value = "更新", notes = "API")
    @RequestMapping(value = "/updateSysUser", method = RequestMethod.POST)
    public ResultVO<?> updateSysUser(@RequestBody SysUserDTO dto) {
        return iSysUserService.updateSysUser(dto);
    }

    @ApiOperation(value = "删除", notes = "API")
    @RequestMapping(value = "/deleteSysUser", method = RequestMethod.POST)
    public ResultVO<?> deleteSysUser(@RequestBody SysUserDTO dto) {
        return iSysUserService.deleteSysUser(dto);
    }
}

