package com.ic.modules.user.service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: CharlesSong
 * Date  : 2015/5/6
 */
public interface IUserService {

    public Map<String,Object> getUser(Map<String,Object> param);

    public int insertUser(Map<String,Object> param);

    public List getList();
}
