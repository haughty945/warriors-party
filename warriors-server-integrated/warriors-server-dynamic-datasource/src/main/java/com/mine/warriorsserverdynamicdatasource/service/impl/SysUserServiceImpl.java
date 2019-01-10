package com.mine.warriorsserverdynamicdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsservercommon.utils.BeanCopyUtil;
import com.mine.warriorsservercommon.utils.ResultVOUtil;
import com.mine.warriorsserverdynamicdatasource.dto.SysUserDTO;
import com.mine.warriorsserverdynamicdatasource.entity.SysUser;
import com.mine.warriorsserverdynamicdatasource.mapper.SysUserMapper;
import com.mine.warriorsserverdynamicdatasource.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : mine_lee
 * @Date : 2019-01-10
 * @Remark :【用户】实现层
 */
@Slf4j
@Transactional
@Service
@DS(value = "slave_1")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @DS(value = "master")
    @Override
    public ResultVO<?> searchSysUserList(SysUserDTO dto) {
        EntityWrapper<SysUser> entityWrapper = new EntityWrapper<SysUser>();
        SysUser entity = new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(sysUserMapper.selectList(entityWrapper));
    }

    @Override
    public ResultVO<?> searchSysUserListPage(SysUserDTO dto) {
        Page<SysUser> page = new Page<SysUser>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<SysUser> entityWrapper = new EntityWrapper<SysUser>();
        SysUser entity = new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(sysUserMapper.selectPage(page, entityWrapper)));
    }

    @Override
    public ResultVO<?> searchSysUserOne(SysUserDTO dto) {
        SysUser entity = new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        return ResultVOUtil.returnSuccess(sysUserMapper.selectOne(entity));
    }

    @Override
    public ResultVO<?> addSysUser(SysUserDTO dto) {
        SysUser entity = new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        sysUserMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateSysUser(SysUserDTO dto) {
        SysUser entity = new SysUser();
        SysUser result = sysUserMapper.selectOne(entity);
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        sysUserMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteSysUser(SysUserDTO dto) {
        SysUser entity = new SysUser();
        SysUser result = sysUserMapper.selectOne(entity);
        return ResultVOUtil.returnSuccess();
    }

}
