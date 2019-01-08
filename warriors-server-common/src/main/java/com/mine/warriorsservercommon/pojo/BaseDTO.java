package com.mine.warriorsservercommon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "公共DTO", description = "公共DTO")
public class BaseDTO {

    @ApiModelProperty(value = "当前页")
    private int current = 1;

    @ApiModelProperty(value = "分页大小")
    private int size = 10;

}