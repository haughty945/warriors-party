package com.mine.warriorsservermybatisplus.service.impl;

import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsservercommon.utils.BeanCopyUtil;
import com.mine.warriorsservercommon.utils.ResultVOUtil;
import com.mine.warriorsservermybatisplus.entity.SysUser;
import com.mine.warriorsservermybatisplus.mapper.SysUserMapper;
import com.mine.warriorsservermybatisplus.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mine.warriorsservermybatisplus.dto.SysUserDTO;
import com.mine.warriorsservermybatisplus.vo.SysUserVO;

/**
 * @Author : mine_lee
 * @Date   : 2019-01-08
 * @Remark :【】实现层
 */
@Slf4j
@Transactional
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ResultVO<?> searchSysUserList(SysUserDTO dto){
    EntityWrapper<SysUser> entityWrapper=new EntityWrapper<SysUser>();
    SysUser entity=new SysUser();
    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    entityWrapper.setEntity(entity);
    return ResultVOUtil.returnSuccess(sysUserMapper.selectList(entityWrapper));
    }

    @Override
    public ResultVO<?> searchSysUserListPage(SysUserDTO dto){
        Page<SysUser> page=new Page<SysUser>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<SysUser> entityWrapper=new EntityWrapper<SysUser>();
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(sysUserMapper.selectPage(page,entityWrapper)));
    }

    @Override
    public ResultVO<?> searchSysUserOne(SysUserDTO dto){
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   	    return ResultVOUtil.returnSuccess(sysUserMapper.selectOne(entity));
    }

    @Override
    public ResultVO<?> addSysUser(SysUserDTO dto){
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
        sysUserMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateSysUser(SysUserDTO dto){
        SysUser entity=new SysUser();
        SysUser result=sysUserMapper.selectOne(entity);
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);
        sysUserMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteSysUser(SysUserDTO dto){
        SysUser entity=new SysUser();
        SysUser result=sysUserMapper.selectOne(entity);
        return ResultVOUtil.returnSuccess();
    }

}
