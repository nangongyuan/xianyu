package com.yuan.xianyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class XianyuApplication {

	public static void main(String[] args) {
		SpringApplication.run(XianyuApplication.class, args);
	}
}
