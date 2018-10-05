package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.pojo.Chat;
import com.yuan.xianyu.service.IChatService;
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
public class ChatServiceImplTest {

	@Autowired
	private IChatService chatService;

	@Test
	public void updateRead() {
		chatService.saveChat(new Chat(4,4,"123",0));
		//chatService.updateRead(4);
	}
}