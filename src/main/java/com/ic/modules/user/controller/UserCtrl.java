package com.ic.modules.user.controller;

import com.ic.core.base.CoreController;
import com.ic.core.interceptors.TokenInterceptor;
import com.ic.core.model.Code;
import com.ic.core.utils.CacheUtils;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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

    public void register(){

    }

    @RequestMapping("/test")
    public void list(HttpServletResponse resp){
        System.out.println("这是user list");

        Map<String,Object> data=new HashMap<String,Object>();
        data.put("user","123456");
        CacheUtils.put("userCache","user", data);
        renderData(resp, Code.SUCCESS, Code.SUCCESS_MSG, data);
    }
}
