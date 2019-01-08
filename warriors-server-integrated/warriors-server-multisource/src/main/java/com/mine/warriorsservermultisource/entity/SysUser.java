package com.mine.warriorsservermultisource.entity;

import lombok.Data;

import java.util.Date;


/**
 * @Author : mine_lee
 * @Date : 2019-01-08
 * @Remark :【】实体类
 */
@Data
public class SysUser {

    /**
     * 主键
     */
    private Long tId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 姓名
     */
    private String tName;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 版本号
     */
    private Long version;
    /**
     * 逻辑删除
     */
    private Integer deleteFlag;

}
