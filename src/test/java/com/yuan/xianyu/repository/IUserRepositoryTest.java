package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IUserRepositoryTest {

	@Autowired
	private IUserRepository userRepository;

	@Test
	public void testSave(){
		User user = new User();
		user.setUsername("1");
		user.setPassword("123");
		user.setEmail("1390311049@qq.com");
		user.setPhone("18888644102");
//		user.setRole(0);
//		user.setCreateTime(new Date());
//		user.setUpdateTime(new Date());
		userRepository.save(user);
	}
}