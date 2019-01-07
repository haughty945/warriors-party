package com.mine.warriorsserveraop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "统一返回", description = "返回对象")
public class GlobalReturn<T> implements Serializable {

    @ApiModelProperty(value = "返回错误代码", example = "返回错误代码")
    private int errcode = 0;

    @ApiModelProperty(value = "返回错误信息描述", example = "返回错误信息描述")
    private String errmsg = "ok";

    @ApiModelProperty(value = "返回对象数据", example = "返回对象数据")
    private T data = null;

}
