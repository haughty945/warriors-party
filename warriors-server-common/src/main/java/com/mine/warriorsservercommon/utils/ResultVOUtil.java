package com.mine.warriorsservercommon.utils;

import com.mine.warriorsservercommon.pojo.ResultVO;

public class ResultVOUtil {

    public static ResultVO<?> returnSuccess() {
        return returnSuccess(null);
    }

    public static ResultVO<?> returnSuccess(Object ret) {
        ResultVO<Object> ResultVO = new ResultVO<>();
        ResultVO.setData(ret);
        return ResultVO;
    }

    public static ResultVO<?> returnFail(Integer code, String msg) {
        return new ResultVO<>(code,msg,null);
    }

}
