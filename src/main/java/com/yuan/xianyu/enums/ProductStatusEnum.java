/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductStatusEnum
 * Author:   Administrator
 * Date:     2018/9/20 0020 10:26
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
 * @create 2018/9/20 0020
 * @since 1.0.0
 */
public enum ProductStatusEnum {
	ING_STATUS(1,"在售"),
	SOLD_OUT(2,"下架"),
	BE_SOLD(3,"已出售");

	private int code;
	private String desc;

	ProductStatusEnum(int code, String desc){
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
