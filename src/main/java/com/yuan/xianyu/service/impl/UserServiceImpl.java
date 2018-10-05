/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.enums.UserRoleEnum;
import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.repository.IUserRepository;
import com.yuan.xianyu.service.IUserService;
import com.yuan.xianyu.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public ServerResponse<Integer> login(User user) {
		User result = userRepository.findByUsername(user.getUsername());
		if (result == null){
			return ServerResponse.createErrorByMessage("用户名不存在");
		}
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
		if (!user.getPassword().equals(result.getPassword())){
			return ServerResponse.createErrorByMessage("密码错误");
		}
		return ServerResponse.createSuccessByData(result.getId());
	}

	@Override
	public ServerResponse<String> register(User user) {
		user.setRole(UserRoleEnum.GENERAL_USER.getCode());
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
		User resutl = userRepository.save(user);
		if (resutl == null){
			return ServerResponse.createError();
		}
		return ServerResponse.createSuccess();
	}

	@Override
	public ServerResponse<String> checkUser(String username) {
		User user = userRepository.findByUsername(username);
		if (user != null){
			return ServerResponse.createError();
		}
		return ServerResponse.createSuccess();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.getOne(id);
	}

	@Override
	public String listAllUser() {
		List<User> userList = userRepository.findAll();
		StringBuilder stringBuilder = new StringBuilder(userList.get(0).getUsername());
		for (int i=1;i<userList.size();i++) {
			stringBuilder.append(",").append(userList.get(i).getUsername());
		}
		return stringBuilder.toString();
	}
}