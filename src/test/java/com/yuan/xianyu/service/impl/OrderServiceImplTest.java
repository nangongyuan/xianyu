package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

@Slf4j
public class OrderServiceImplTest {

	@Autowired
	private IOrderService orderService;

	@Test
	public void listMyOrder() {

		Page page = orderService.listMyOrder(4,0,10);
		page.getTotalPages();

	}
}