package com.mine.warriorsservermultisource.mapper.first;


import com.mine.warriorsservermultisource.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FirstSysUserMapper {

    public SysUser queryAll();
}
