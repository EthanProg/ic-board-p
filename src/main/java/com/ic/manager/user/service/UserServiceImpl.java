package com.ic.manager.user.service;

import com.ic.core.model.CodeModel;
import com.ic.core.utils.IdGenerate;
import com.ic.manager.user.mapper.UserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:用户服务接口实现类
 * Author: Charles
 * Date  : 2014/12/13
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	private UserServiceMapper userServiceMapper;

	@Autowired
	public void setUserServiceMapper(UserServiceMapper userServiceMapper) {
		this.userServiceMapper = userServiceMapper;
	}

	@Override
	public List<Map<String,Object>> queryUserList(Map<String, Object> params) {
		return userServiceMapper.queryUserList(params);
	}

	@Override
	public Map<String,Object> queryUser(Map<String, Object> params) {
		return userServiceMapper.queryUser(params);
	}


	@Override
	public Map<String, Object> addUser(Map<String, Object> params) {
		params.put("user_id", IdGenerate.nextId());
		int nums= userServiceMapper.addUser(params);
		Map<String,Object> rt=new HashMap<String, Object>();
		if(nums>0){
			rt.put("code", CodeModel.CODE_SUCCESS);
			rt.put("msg","新增用户成功");
		}else{
			//如何提示？
		}
		return rt;
	}

	@Override
	public Map<String, Object> deleteUser(Map<String, Object> params) {
		int nums= userServiceMapper.deleteUser(params);
		Map<String,Object> rt=new HashMap<String, Object>();
		if(nums>0){
			rt.put("code", CodeModel.CODE_SUCCESS);
			rt.put("msg","删除用户成功");
		}else{
			rt.put("code", CodeModel.CODE_SUCCESS_EMPTY);
			rt.put("msg","无此用户");
		}
		return rt;
	}

	@Override
	public Map<String, Object> updateUser(Map<String, Object> params) {
		int nums= userServiceMapper.updateUser(params);
		Map<String,Object> rt=new HashMap<String, Object>();
		if(nums>0){
			rt.put("code", CodeModel.CODE_SUCCESS);
			rt.put("msg","更新用户成功");
		}else{
			rt.put("code", CodeModel.CODE_SUCCESS_EMPTY);
			rt.put("msg","无此用户");
		}
		return rt;
	}
}
