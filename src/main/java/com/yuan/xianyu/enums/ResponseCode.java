/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ResponseCode
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.enums;

import lombok.Getter;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Getter
public enum  ResponseCode {
	SUCCESS(0,"SUCCESS"),
	ERROR(1,"ERROR"),
	NEED_LOGIN(10,"未登录"),
	ILLEGAL_ARGUMENT(2,"参数错误");

	private int code;
	private String desc;

	ResponseCode(int code, String desc){
		this.code = code;
		this.desc = desc;
	}

}