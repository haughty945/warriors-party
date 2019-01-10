package com.mine.warriorsserverdynamicdatasource.dto;

import com.mine.warriorsservercommon.pojo.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author : mine_lee
 * @Date   : 2019-01-10
 * @Remark :【用户】交互层
 */
@Data
@ApiModel(value = "【用户】交互层")
public class SysUserDTO extends BaseDTO {

    @ApiModelProperty(value = "主键ID")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "地址")
    private String userAddress;

    @ApiModelProperty(value = "备注")
    private String userRemark;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "逻辑删除 0 存在 1 删除")
    private Integer deleteFlag;

 }
