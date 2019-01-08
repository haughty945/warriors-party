package com.mine.warriorsservermybatisplus.entity;

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
 * @Date   : 2019-01-08
 * @Remark :【】实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    /**
     * 主键
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Long tId;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 姓名
     */
    @TableField("t_name")
    private String tName;
    /**
     * 修改时间
     */
    @TableField("update_date")
    private Date updateDate;
    /**
     * 版本号
     */
    @Version
    private Long version;
    /**
     * 逻辑删除
     */
    @TableField("delete_flag")
    @TableLogic
    private Integer deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.tId;
    }

}
