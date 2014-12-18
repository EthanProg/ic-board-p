package com.ic.manager.user.mapper;

import com.ic.manager.user.model.User;

import java.util.List;
import java.util.Map;

/**
 * 功能：
 * @author 郑斌	2014年7月22日 上午11:46:41
 * 修改说明：
 */
public interface UserServiceMapper {

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
