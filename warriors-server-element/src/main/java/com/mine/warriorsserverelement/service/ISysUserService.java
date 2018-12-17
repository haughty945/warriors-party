package com.mine.warriorsserverelement.service;

import com.baomidou.mybatisplus.service.IService;
import com.mine.warriorsserverelement.dto.SysUserDTO;
import com.mine.warriorsserverelement.entity.SysUser;
import com.mine.warriorsservermybatisplus.common.ResultVO;

/**
 * @Author : mine_lee
 * @Date : 2018-12-17
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
