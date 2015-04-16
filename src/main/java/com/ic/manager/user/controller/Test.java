package com.ic.manager.user.controller;

import com.ic.core.impl.CoreController;
import com.ic.core.page.Page;
import com.ic.manager.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Charles
 * Date  : 2014/12/16
 */
@Controller
public class Test extends CoreController{
    @Autowired
    private IUserService userService;

    @RequestMapping("/userinfo/{id}")
    public String show(@PathVariable Long id) throws Exception {
        return "/test";
    }





    @RequestMapping("/test")
    public String userList(HttpServletRequest req){
        //后台连接直接获取
        Page page = new Page();
        page.setCurrentPage(1);
        page.setPageSize(1);
        page.setPagination(true);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page", page);
        List<Map<String,Object>> userList=userService.queryUserList(map);
        System.out.println("查询到的UserList："+userList);
        System.out.println("当前页:page="+page.getCurrentPage());
        System.out.println("pageSize="+page.getPageSize());
        System.out.println("totalPages="+page.getTotalPages());
        System.out.println("totalRows="+page.getTotalRows());
        System.out.println("pagedView="+page.getPagedView());
        System.out.println("");
        req.setAttribute("page",page);
        req.setAttribute("user",userList.get(0));
        return "/test";
    }
}
