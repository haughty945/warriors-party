package com.mine.warriorsservercommon.config.exception;

import com.mine.warriorsservercommon.pojo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

/**
 * @Program: warriors-party
 * @Description: 全局异常处理
 * @Author: Mine.Lee
 * @Create: 2018-11-15 18:42
 * @Version: v1.0
 */
@Slf4j
@Controller
@RestControllerAdvice
public class GlobalExceptionHandler implements ErrorController {

    /**
     * @return java.lang.String 必须定义为/error
     * @throws ..
     * @description NoHandlerMapper 映射/接口/路径不存在
     * @remark 当映射/接口/路径不存在时的返回路径
     * @author Mine.Lee
     * @create 2019/1/15 20:00
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * @param request
     * @return com.mine.warriorsservercommon.pojo.ResultVO
     * @description 映射/接口/路径不存在时的返回
     * @remark 映射/接口/路径不存在时的返回
     * @author Mine.Lee
     * @create 2019/1/15 20:01
     */
    @RequestMapping("/error")
    public ResultVO NoHandlerFoundException(HttpServletRequest request) {
        return new ResultVO(404,"接口不存在",null);
    }

    /**
     * @param request
     * @param e
     * @return com.mine.warriorsservercommon.pojo.ResultVO
     * @throws ..
     * @description 统一异常处理
     * @remark ..
     * @author Mine.Lee
     * @create 2019/1/15 20:03
     */
    @ExceptionHandler(value = Exception.class)
    public ResultVO ServletException(HttpServletRequest request, Exception e) {
        log.error("EXCEPTION_INTERCEPT" + " [ " + request.getRequestURI() + " ] " + "接口出现错误 , " + e.getMessage());
        ResultVO ret = new ResultVO();
        if (e instanceof HttpRequestMethodNotSupportedException) {
            ret.setCode(400);
            ret.setMsg("请求方式不正确");
            ret.setData(e.getMessage());
        } else if (e instanceof HttpMessageNotReadableException || e instanceof HttpMediaTypeNotSupportedException || e instanceof MissingServletRequestParameterException) {
            ret.setCode(400);
            ret.setMsg("请求参数不正确");
            ret.setData(e.getMessage());
        } else {
            ret.setCode(500);
            ret.setMsg("服务器内部异常");
//            log.error("LOG_ID : " + request.getAttribute("logId"));
            log.error("RESPONSE_CODE : " + ret.getCode());
            log.error("ERROR_DETAIL" + e.getMessage());
            e.printStackTrace();
        }

        return ret;
    }
}
