/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IUserService
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.User;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
public interface IUserService {
	ServerResponse<Integer> login(User user);

	ServerResponse<String> register(User user);

	ServerResponse<String> checkUser(String username);

	User getUserById(Integer id);

	String listAllUser();

}
