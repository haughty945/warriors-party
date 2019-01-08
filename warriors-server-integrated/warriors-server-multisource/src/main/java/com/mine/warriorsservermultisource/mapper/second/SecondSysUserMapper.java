package com.mine.warriorsservermultisource.mapper.second;


import com.mine.warriorsservermultisource.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecondSysUserMapper {

    public SysUser queryAll();
}
