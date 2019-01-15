package com.mine.warriorsservercommon.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @program: warriors-party
 * @description: 公共DTO
 * @author: Mine.Lee
 * @create: 2019-01-15 19:52
 * @version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "统一返回", description = "返回对象")
public class ResultVO<T> implements Serializable {

    @ApiModelProperty(value = "返回错误代码", example = "200")
    private int code = 200;

    @ApiModelProperty(value = "返回错误信息描述", example = "SUCCESS")
    private String msg = "success";

    @ApiModelProperty(value = "返回对象数据", example = "返回对象数据")
    private T data = null;

}
