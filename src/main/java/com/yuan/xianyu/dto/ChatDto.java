/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ChatDto
 * Author:   Administrator
 * Date:     2018/9/21 0021 20:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/21 0021
 * @since 1.0.0
 */
@Data
public class ChatDto {

	private Integer userId;

	private String userName;

	private String msg;


	public static void main(String[] args) {
		ChatDto chatDto = new ChatDto();
		chatDto.setUserId(1);
		chatDto.setUserName("name");
		chatDto.setMsg("hello");
		try {
			String msg = new ObjectMapper().writeValueAsString(chatDto);
			System.out.println(msg);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}