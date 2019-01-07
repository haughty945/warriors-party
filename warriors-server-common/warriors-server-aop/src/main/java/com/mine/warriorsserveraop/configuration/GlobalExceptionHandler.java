package com.mine.warriorsserveraop.configuration;

import com.mine.warriorsserveraop.common.GlobalReturn;
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

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@ControllerAdvice
public class GlobalExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/noHandlerFoundException";
    }

    @RequestMapping("/noHandlerFoundException")
    @ResponseBody
    public GlobalReturn NoHandlerFoundException(HttpServletRequest request) {
        GlobalReturn ret = new GlobalReturn();
        ret.setErrcode(404);
        ret.setErrmsg("接口不存在");
        return ret;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public GlobalReturn ServletException(HttpServletRequest request, Exception e) throws Exception {
        log.error("【异常拦截】" + "[" + request.getRequestURI() + "]" + "接口出现错误," + e.getMessage());
        GlobalReturn ret = new GlobalReturn();
        if (e instanceof HttpRequestMethodNotSupportedException) {
            ret.setErrcode(400);
            ret.setErrmsg("请求方式不正确");
        } else if (e instanceof HttpMessageNotReadableException || e instanceof HttpMediaTypeNotSupportedException || e instanceof MissingServletRequestParameterException) {
            ret.setErrcode(400);
            ret.setErrmsg("请求参数不正确");
        } else {
            ret.setErrcode(500);
            ret.setErrmsg("服务器内部异常");
        }
        e.printStackTrace();
        return ret;
    }
}
