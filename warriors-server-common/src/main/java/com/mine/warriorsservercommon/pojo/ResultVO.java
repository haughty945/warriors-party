package com.mine.warriorsservercommon.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "统一返回", description = "返回对象")
public class ResultVO<T> implements Serializable {

    @ApiModelProperty(value = "返回错误代码", example = "200")
    private int code = 200;

    @ApiModelProperty(value = "返回错误信息描述", example = "SUCCESS")
    private String msg = "success";

    @ApiModelProperty(value = "返回对象数据", example = "返回对象数据")
    private T data = null;

    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO() {
    }
}
