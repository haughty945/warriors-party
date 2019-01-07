package com.mine.warriorsserverjpa.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Table - 映射表名
 * @Id - 主键
 * @GeneratedValue(strategy=GenerationType.IDENTITY) - 自动递增生成
 * @Column(name = “dict_name”,columnDefinition=”varchar(100) COMMENT ‘字典名’”) - 字段名、类型、注释
 * @UpdateTimestamp - 更新时自动更新时间
 * @CreationTimestamp - 创建时自动更新时间
 * @Version - 版本号，更新时自动加1
 * @Column 详解 ：
 * https://blog.csdn.net/qq_16769857/article/details/80347459
 */
@Data
@Entity
@Table(name = "sys_user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自动递增生成
    @Column(name = "t_id", updatable = false, nullable = false, columnDefinition = " bigint(10) COMMENT '主键' ")

    private Long id;

    @Column(name = "t_name", columnDefinition = " varchar(10) COMMENT '姓名' ")
    private String name;

    @CreationTimestamp
    @Column(name = "create_date",updatable = false, columnDefinition = " TIMESTAMP COMMENT '创建时间' ")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "update_date", columnDefinition = " TIMESTAMP COMMENT '修改时间' ")
    private Date updateDate;

    @Version
    @Column(name = "version", columnDefinition = " bigint(20) COMMENT '版本号' ")
    private Long varsion;
}
