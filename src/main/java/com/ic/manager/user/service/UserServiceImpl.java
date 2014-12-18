package com.ic.manager.user.service;

import java.util.List;
import java.util.Map;

import com.ic.manager.user.mapper.UserServiceMapper;
import com.ic.manager.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:用户服务接口实现类
 * Author: Charles
 * Date  : 2014/12/13
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserServiceMapper userServiceMapper;

	@Override
	public List<Map<String,Object>> queryUserList(Map<String, Object> params) {
		return userServiceMapper.queryUserList(params);
	}

	@Override
	public Map<String,Object> queryUser(Map<String, Object> params) {
		return userServiceMapper.queryUser(params);
	}
}
