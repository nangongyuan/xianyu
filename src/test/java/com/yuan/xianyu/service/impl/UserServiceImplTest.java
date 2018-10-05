package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

	@Autowired
	private IUserService userService;

	@Test
	public void login() {
	}

	@Test
	public void register() {
		User user = new User();
		user.setPassword("12345678");
		user.setUsername("admin");
		user.setPhone("18888644102");
		userService.register(user);
	}
}