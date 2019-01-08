package com.mine.warriorsservercommon.utils;

import com.mine.warriorsservercommon.pojo.GlobalVO;

public class GlobalVOUtil {

    public static GlobalVO<?> returnSuccess() {
        return returnSuccess(null);
    }

    public static GlobalVO<?> returnSuccess(Object ret) {
        GlobalVO<Object> GlobalVO = new GlobalVO<>();
        GlobalVO.setCode(200);
        GlobalVO.setMsg("SUCCESS");
        GlobalVO.setData(ret);
        return GlobalVO;
    }

    public static GlobalVO<?> returnSuccess(Integer code,String msg, Object ret) {
        return new GlobalVO(code,msg,ret);
    }

    public static GlobalVO<?> returnFail(Integer code, String msg) {
        return new GlobalVO<>(code,msg,null);
    }

}
