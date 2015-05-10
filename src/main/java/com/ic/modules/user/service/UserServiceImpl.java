package com.ic.modules.user.service;

import com.ic.core.config.Global;
import com.ic.core.utils.IdGen;
import com.ic.core.utils.MD5Util;
import com.ic.modules.user.dao.UserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: CharlesSong
 * Date  : 2015/5/7
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserServiceMapper userServiceMapper;

    @Override
    public Map<String, Object> getUser(Map<String, Object> param) {
        return userServiceMapper.getUser(param);
    }

    @Override
    public int insertUser(Map<String, Object> param) {
        param.put("userId", IdGen.uuid());
        param.put("userPwd", MD5Util.getMD5String(Global.getConfig("md5salt")+(String)param.get("userPwd")));
        return userServiceMapper.insertUser(param);
    }

    @Override
    public List getList() {
        return null;
    }

}
