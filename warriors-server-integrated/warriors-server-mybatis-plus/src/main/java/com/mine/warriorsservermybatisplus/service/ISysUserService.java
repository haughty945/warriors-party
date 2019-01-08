package com.mine.warriorsservermybatisplus.service;

import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsservermybatisplus.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

import com.mine.warriorsservermybatisplus.dto.SysUserDTO;
import com.mine.warriorsservermybatisplus.vo.SysUserVO;

/**
 * @Author : mine_lee
 * @Date   : 2019-01-08
 * @Remark :【】代理层
 */
public interface ISysUserService extends IService<SysUser> {

   public ResultVO<?> searchSysUserList(SysUserDTO dto);

   public ResultVO<?> searchSysUserListPage(SysUserDTO dto);

   public ResultVO<?> searchSysUserOne(SysUserDTO dto);

   public ResultVO<?> addSysUser(SysUserDTO dto);

   public ResultVO<?> updateSysUser(SysUserDTO dto);

   public ResultVO<?> deleteSysUser(SysUserDTO dto);

}
