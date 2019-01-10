package com.mine.warriorsserverdynamicdatasource.entity;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @Author : mine_lee
 * @Date   : 2019-01-10
 * @Remark :【用户】实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 密码
     */
    @TableField("pass_word")
    private String passWord;
    /**
     * 地址
     */
    @TableField("user_address")
    private String userAddress;
    /**
     * 备注
     */
    @TableField("user_remark")
    private String userRemark;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 逻辑删除 0 存在 1 删除
     */
    @TableField("delete_flag")
    @TableLogic
    private Integer deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
