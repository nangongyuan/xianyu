/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OrderController
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.controller;

import com.yuan.xianyu.common.Const;
import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.enums.ResponseCode;
import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping("/save")
	public ServerResponse saveOrder(HttpSession httpSession, String username, Integer productId){
		User user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		if (user == null){
			return ServerResponse.createError(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc(),null);
		}
		return orderService.saveOrder(user.getId(),username,productId);
	}
}