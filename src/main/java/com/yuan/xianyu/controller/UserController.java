/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.controller;

import com.yuan.xianyu.common.Const;
import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/login")
	public ServerResponse<Integer> login(User user, HttpSession httpSession){
		ServerResponse<Integer> result = userService.login(user);
		if (result.getStatus() == 0){
			httpSession.setAttribute(Const.LOGIN_USER,userService.getUserById(result.getData()));
		}
		return result;
	}

	@GetMapping("/logout")
	public void logout(Model model,HttpSession session, HttpServletResponse response) throws IOException {
		session.removeAttribute(Const.LOGIN_USER);
		response.sendRedirect("/login");
	}

	@PostMapping("/register")
	public ServerResponse<String> register(User user){
		return userService.register(user);
	}

	@GetMapping("/check_user")
	public ServerResponse<String> checkUser(String username){
		return userService.checkUser(username);
	}

}