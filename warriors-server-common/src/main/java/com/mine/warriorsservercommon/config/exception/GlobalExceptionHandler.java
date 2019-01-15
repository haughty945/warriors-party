package com.mine.warriorsservercommon.config.exception;

import com.mine.warriorsservercommon.pojo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler implements ErrorController {

    /**
     * @param
     * @return java.lang.String 当映射/接口/路径不存在时的返回路径
     * @throws ..
     * @description NoHandlerMapper 映射/接口/路径不存在
     * @remark 必须定义为/error
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
    @ResponseBody
    public ResultVO NoHandlerFoundException(HttpServletRequest request) {
        ResultVO ret = new ResultVO();
        ret.setCode(404);
        ret.setMsg("接口不存在");
        return ret;
    }

    /**
     * @description 统一异常处理
     * @remark ..
     * @author Mine.Lee
     * @create 2019/1/15 20:03
     * @param request
     * @param e
     * @return com.mine.warriorsservercommon.pojo.ResultVO
     * @throws ..
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO ServletException(HttpServletRequest request, Exception e) {
        log.error("EXCEPTION_INTERCEPT" + " [ " + request.getRequestURI() + " ] " + "接口出现错误 , " + e.getMessage());
        ResultVO ret = new ResultVO();
        if (e instanceof HttpRequestMethodNotSupportedException) {
            ret.setCode(400);
            ret.setMsg("请求方式不正确");
        } else if (e instanceof HttpMessageNotReadableException || e instanceof HttpMediaTypeNotSupportedException || e instanceof MissingServletRequestParameterException) {
            ret.setCode(400);
            ret.setMsg("请求参数不正确");
        } else {
            ret.setCode(500);
            ret.setMsg("服务器内部异常");
            e.printStackTrace();
        }
        return ret;
    }
}
