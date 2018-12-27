package com.mine.warriorsserverelement.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author : mine_lee
 * @Date   : 2018-12-17
 * @Remark :【用户】返回层
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "【用户】返回层")
public class SysUserVO {

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