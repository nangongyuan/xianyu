package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.service.IProductService;
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
public class ProductServiceImplTest {

	@Autowired
	private IProductService productService;

	@Test
	public void listProductByCategoryId() {

	}

	@Test
	public void listProductByCategoryId1() {
		productService.listProductByCategoryId(2115,1,0,0,0,10);
	}
}