package com.ic.manager.user.service;

import com.ic.manager.user.model.User;

import java.util.List;
import java.util.Map;

/**
 * Description:用户服务接口
 * Author: Charles
 * Date  : 2014/12/13
 */
public interface IUserService {

	/**
	 * 查询用户列表
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> queryUserList(Map<String,Object> params);

	/**
	 * 查询单个用户
	 * @param params
	 * @return
	 */
	public Map<String,Object> queryUser(Map<String,Object> params);

}
