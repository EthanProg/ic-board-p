package com.ic.manager.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Desc:
 * Author: Charles
 * Date  : 2014/12/23
 * Email : Charles2Song@gmail.com
 */
@Controller
public class LoginController {
    public String forLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public Map<String,Object> login(HttpServletRequest req,HttpServletResponse res){
        return null;
    }
}
