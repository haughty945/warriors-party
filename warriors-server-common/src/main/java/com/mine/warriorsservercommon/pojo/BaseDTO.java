package com.mine.warriorsservercommon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: warriors-party
 * @description: 公共DTO
 * @author: Mine.Lee
 * @create: 2019-01-15 19:52
 * @version: v1.0
 */
@Data
@ApiModel(value = "公共DTO", description = "公共DTO")
public class BaseDTO {

    @ApiModelProperty(value = "起始页")
    private int current = 1;

    @ApiModelProperty(value = "分页大小")
    private int size = 10;

}