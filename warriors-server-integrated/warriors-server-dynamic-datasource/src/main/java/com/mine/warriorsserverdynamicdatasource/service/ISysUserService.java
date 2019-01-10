package com.mine.warriorsserverdynamicdatasource.service;

import com.baomidou.mybatisplus.service.IService;
import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsserverdynamicdatasource.dto.SysUserDTO;
import com.mine.warriorsserverdynamicdatasource.entity.SysUser;

/**
 * @Author : mine_lee
 * @Date   : 2019-01-10
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
