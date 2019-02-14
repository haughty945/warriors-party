package com.mine.warriorswarsso.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: warriors-party
 * @description: 控制层
 * @author: Mine.Lee
 * @create: 2019-02-14 17:29
 * @version: v1.0
 * @remark: ..
 */
@RestController
@RequestMapping("/admin")
public class SsoController {

    @GetMapping("/setSessionId")
    public String setredisResult(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userToken", session.getId());
        return "设置ok...";
    }

    @GetMapping("/getSessionId")
    public String redisResult(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("userToken");
        return "userToken : " + sessionId;
    }
}
