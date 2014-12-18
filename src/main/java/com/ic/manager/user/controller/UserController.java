package com.ic.manager.user.controller;

import com.ic.core.enums.LogLevel;
import com.ic.core.impl.CoreController;
import com.ic.manager.user.model.User;
import com.ic.manager.user.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Charles
 * Date  : 2014/12/13
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends CoreController {

    private IUserService userService;

     //为什么要自动包装在set上呢？而不是直接在  private定义上？
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 功能：查询用户列表
     * @return JSON数组
     */
    @RequestMapping("/list")
    public @ResponseBody List<Map<String,Object>> userList(){
        List<Map<String,Object>> userList=userService.queryUserList(null);
        return userList;
    }


    /**
     * 功能：单个用户
     * @param userId
     * @return JSON对象
     */
    @RequestMapping("/{userId}")
    public @ResponseBody Map<String,Object> user(@PathVariable String userId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("userId",userId);
        System.out.println("用户id："+userId);
        return userService.queryUser(params);
    }

    @RequestMapping("/add")
    public String add(){
        return null;
    }
}
