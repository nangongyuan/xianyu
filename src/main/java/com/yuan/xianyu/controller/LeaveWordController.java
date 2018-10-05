/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LeaveWordController
 * Author:   Administrator
 * Date:     2018/9/22 0022 10:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.controller;

import com.yuan.xianyu.common.Const;
import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.LeaveWord;
import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.service.ILeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
@RestController
@RequestMapping("/leave_word")
public class LeaveWordController {

	@Autowired
	private ILeaveWordService leaveWordService;

	@RequestMapping("/save")
	public ServerResponse saveLeaveWord(LeaveWord leaveWord, HttpSession httpSession){
		User user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		if (user == null){
			return ServerResponse.createErrorByMessage("未登录");
		}
		leaveWord.setSender(user.getId());
		return leaveWordService.saveLeaveWord(leaveWord);
	}
}