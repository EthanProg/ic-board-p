package com.ic.modules.user.controller;

import com.ic.core.impl.CoreController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: CharlesSong
 * Date  : 2015/4/26
 */
@RestController
@RequestMapping("/api/user")
public class UserCtrl extends CoreController {
    @RequestMapping("/list")
    public void list(){
        System.out.println("这是user list");
        logDebug("这是user list ");
    }
}
