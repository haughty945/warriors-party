package com.mine.warriorsservermybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsservermybatisplus.dto.SysUserDTO;
import com.mine.warriorsservermybatisplus.entity.SysUser;

/**
 * @Author : mine_lee
 * @Date : 2018-12-27
 * @Remark :【用户】代理层
 */
public interface ISysUserService extends IService<SysUser> {

    public ResultVO<?> searchSysUserList(SysUserDTO dto);

    public ResultVO<?> searchSysUserListPage(SysUserDTO dto);

    public ResultVO<?> searchSysUserOne(SysUserDTO dto);

    public ResultVO<?> addSysUser(SysUserDTO dto);

    public ResultVO<?> updateSysUser(SysUserDTO dto);

    public ResultVO<?> deleteSysUser(SysUserDTO dto);

}
