package com.ic.modules.user.dao;

import java.util.Map;

/**
 * Description:
 * Author: CharlesSong
 * Date  : 2015/5/7
 */
public interface UserServiceMapper {
    public Map<String,Object> getUser(Map<String,Object> param);

    public int insertUser(Map<String,Object> param);
}
