package com.ic.manager.user.controller;

import com.ic.core.enums.LogLevel;
import com.ic.core.impl.CoreController;
import com.ic.core.model.CodeModel;
import com.ic.core.page.Page;
import com.ic.core.utils.JSONUtil;
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
@RequestMapping("/user")
public class UserController extends CoreController {

    private IUserService userService;

     //为什么要自动包装在set上呢？而不是直接在  private定义上？
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/{currentPage}/{pageSize}")
    public @ResponseBody Map<String,Object> userListPage(@PathVariable int currentPage,@PathVariable int pageSize){
        super.execute();
        Page page = new Page();
        if(currentPage>1){
            page.setCurrentPage(currentPage);
        }else {
            page.setCurrentPage(1);
        }
        if (pageSize==0){
            page.setPageSize(10);
        }else{
            page.setPageSize(pageSize);
        }
        page.setPagination(true);
        params.put("page", page);
        List<Map<String,Object>> userList=userService.queryUserList(params);

        returnMap.put("userList",userList);
        returnMap.put("page",JSONObject.fromObject(page));
        return returnMap;
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
        params.put("user_id",userId);
        System.out.println("用户id："+userId);
        return userService.queryUser(params);
    }

    /**
     * 功能：用户添加。inJson=按照表中字段组织的json字符串
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Map<String,Object> add(HttpServletRequest req){
        String inJson=req.getParameter("inJson");
        if(inJson!=null && !inJson.equals("")){
            params= JSONUtil.parseJSONString2Map(inJson);
            returnMap=userService.addUser(params);
        }else{
            returnMap.put("code", CodeModel.CODE_EMPTY_FAILURE);
            returnMap.put("msg", "参数为空");
        }
        return returnMap;
    }

    /**
     *
     * @param userId
     * @return
     */
    @RequestMapping("/del/{userId}")
    public @ResponseBody Map<String,Object> delete(@PathVariable String userId){
        super.execute();
        params.put("user_id",userId);
        Map<String,Object> rt=userService.deleteUser(params);
        return rt;
    }

    @RequestMapping("/update")
    public Map<String,Object> update(HttpServletRequest req){
        String inJson=req.getParameter("inJson");
        if(inJson!=null && !inJson.equals("")){
            params= JSONUtil.parseJSONString2Map(inJson);
            returnMap=userService.updateUser(params);
        }else{
            returnMap.put("code", CodeModel.CODE_EMPTY_FAILURE);
            returnMap.put("msg", "参数为空");
        }
        return returnMap;
    }
}
