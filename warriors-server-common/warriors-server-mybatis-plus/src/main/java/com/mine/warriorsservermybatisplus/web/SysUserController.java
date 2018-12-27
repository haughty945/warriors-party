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
 * @Date : 2018-12-27
 * @Remark :【用户】控制层
 */
@Slf4j
@Api(tags = {"【用户】模块API"})
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @ApiOperation(value = "用户列表查询", notes = "用户API")
    @RequestMapping(value = "/searchSysUserList", method = RequestMethod.POST)
    public ResultVO<List<SysUser>> searchSysUserList(@RequestBody SysUserDTO dto) {
        return (ResultVO<List<SysUser>>) iSysUserService.searchSysUserList(dto);
    }

    @ApiOperation(value = "用户列表分页查询", notes = "用户API")
    @RequestMapping(value = "/searchSysUserListPage", method = RequestMethod.POST)
    public ResultVO<Page<SysUser>> searchSysUserListPage(@RequestBody SysUserDTO dto) {
        return (ResultVO<Page<SysUser>>) iSysUserService.searchSysUserListPage(dto);
    }

    @ApiOperation(value = "用户详细查询", notes = "用户API")
    @RequestMapping(value = "/searchSysUserOne", method = RequestMethod.POST)
    public ResultVO<SysUser> searchSysUserOne(@RequestBody SysUserDTO dto) {
        return (ResultVO<SysUser>) iSysUserService.searchSysUserOne(dto);
    }

    @ApiOperation(value = "用户添加", notes = "用户API")
    @RequestMapping(value = "/addSysUser", method = RequestMethod.POST)
    public ResultVO<?> addSysUser(@RequestBody SysUserDTO dto) {
        return iSysUserService.addSysUser(dto);
    }

    @ApiOperation(value = "用户更新", notes = "用户API")
    @RequestMapping(value = "/updateSysUser", method = RequestMethod.POST)
    public ResultVO<?> updateSysUser(@RequestBody SysUserDTO dto) {
        return iSysUserService.updateSysUser(dto);
    }

    @ApiOperation(value = "用户删除", notes = "用户API")
    @RequestMapping(value = "/deleteSysUser", method = RequestMethod.POST)
    public ResultVO<?> deleteSysUser(@RequestBody SysUserDTO dto) {
        return iSysUserService.deleteSysUser(dto);
    }
}

