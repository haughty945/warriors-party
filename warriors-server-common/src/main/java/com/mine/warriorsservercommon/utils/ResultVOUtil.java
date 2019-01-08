package com.mine.warriorsservercommon.utils;

import com.mine.warriorsservercommon.pojo.ResultVO;

public class ResultVOUtil {

    public static ResultVO<?> returnSuccess() {
        return returnSuccess(null);
    }

    public static ResultVO<?> returnSuccess(Object ret) {
        ResultVO<Object> ResultVO = new ResultVO<>();
        ResultVO.setCode(200);
        ResultVO.setMsg("SUCCESS");
        ResultVO.setData(ret);
        return ResultVO;
    }

    public static ResultVO<?> returnSuccess(Integer code, String msg, Object ret) {
        return new ResultVO(code,msg,ret);
    }

    public static ResultVO<?> returnFail(Integer code, String msg) {
        return new ResultVO<>(code,msg,null);
    }

}
