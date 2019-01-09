package com.mine.warriorsservermultisource.mapper;

import com.mine.warriorsservermultisource.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    public SysUser queryAll();
}
