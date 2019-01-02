package com.mine.warriorsservermybatisplus.dto;

import com.mine.warriorsservercommon.pojo.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author : mine_lee
 * @Date : 2018-12-29
 * @Remark :【】交互层
 */
@Data
public class SysUserDTO extends BaseDTO {

    @ApiModelProperty(value = "主键")
    private Long tId;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "姓名")
    private String tName;

    @ApiModelProperty(value = "修改时间")
    private Date updateDate;

    @ApiModelProperty(value = "版本号")
    private Long version;

    @ApiModelProperty(value = "逻辑删除")
    private Integer deleteFlag;

}
