package com.ic.modules.user.controller;

import com.ic.core.base.CoreController;
import com.ic.core.config.Global;
import com.ic.core.mapper.JsonMapper;
import com.ic.core.model.Code;
import com.ic.core.utils.MD5Util;
import com.ic.modules.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: CharlesSong
 * Date  : 2015/4/26
 */
@RestController
@RequestMapping("/api/user")
public class UserCtrl extends CoreController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public void login(HttpServletRequest req, HttpServletResponse resp, HttpSession session){
        Map<String, Object> param = (Map<String, Object>) req.getAttribute("param");
        Map<String, Object> user = userService.getUser(param);
        if(user== null){
            renderData(Code.FAIL, "用户不存在", null);
        }else{
            if(!user.get("user_pwd").equals(MD5Util.getMD5String(Global.getConfig("md5salt")+param.get("userPwd")))){
                renderData(Code.FAIL, "用户名/密码错误", null);
            }else{
                renderData(Code.SUCCESS,"登录成功",user);
            }
        }
    }

    @RequestMapping("/reg")
    public void register(HttpServletRequest req,HttpServletResponse resp,HttpSession session){
        Map<String, Object> param = (Map<String, Object>) req.getAttribute("param");
        if(param.get("userName")==null || param.get("userPwd") == null) {
            renderData(Code.PARAMS_ERROR, "请输入用户名/密码", null);
        }else{
            Map<String, Object> out = userService.getUser(param);
            String exists = (String) session.getAttribute("exists");
            if ("1".equals(exists) || out != null) {
                renderData(Code.FAIL, "用户已经存在，请不要重复注册", null);
            } else {
                int rtn = userService.insertUser(param);
                if (rtn == 1) {
                    renderData(Code.SUCCESS, "用户注册成功", null);
                } else {
                    renderData(Code.FAIL, "用户注册失败", null);
                }
            }
        }

    }

    @RequestMapping("/check")
    public void check(HttpServletRequest req,HttpServletResponse resp,HttpSession session){
        Map<String, Object> param = (Map<String, Object>) req.getAttribute("param");
        if(param.get("userName")==null){
            renderData(Code.PARAMS_ERROR, "请输入用户名", null);
        }else{
            Map<String, Object> out = userService.getUser(param);
            if (out == null) {
                out = new HashMap<String, Object>();
                out.put("exists", "0");
            } else {
                out = new HashMap<String, Object>();
                out.put("exists", "1");
            }
            renderData(Code.SUCCESS, "校验用户是否存在成功", out);
        }
    }
}
