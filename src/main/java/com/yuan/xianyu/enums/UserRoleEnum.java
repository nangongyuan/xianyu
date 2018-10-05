/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserRoleEnum
 * Author:   Administrator
 * Date:     2018/9/19 0019 9:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.enums;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/19 0019
 * @since 1.0.0
 */
public enum UserRoleEnum {

	ADMIN_USER(0,"管理员"),
	GENERAL_USER(1,"普通用户");

	private int code;

	private String msg;

	UserRoleEnum(int code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}
}
