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

@Slf4j
@Controller
@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    @ResponseBody
    public ResultVO NoHandlerFoundException(HttpServletRequest request) {
        ResultVO ret = new ResultVO();
        ret.setCode(404);
        ret.setMsg("接口不存在");
        return ret;
    }

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
