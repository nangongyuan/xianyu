/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ServerResponse
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yuan.xianyu.enums.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */

@Data
public class ServerResponse <T> implements Serializable {

	private Integer status;

	private String msg;

	private T data;

	private ServerResponse(Integer status, String msg){
		this.status = status;
		this.msg = msg;
	}

	private ServerResponse(Integer status, String msg, T data){
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public static <T> ServerResponse<T> createError(){
		return new ServerResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
	}

	public static <T> ServerResponse<T> createError(Integer code, String msg, T data){
		return new ServerResponse<>(code, msg, data);
	}

	public static <T> ServerResponse<T> createErrorByMessage(String msg){
		return new ServerResponse<>(ResponseCode.ERROR.getCode(),msg);
	}

	public static <T> ServerResponse<T> createErrorByData(T data){
		return new ServerResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc(),data);
	}

	public static <T> ServerResponse<T> createSuccess(){
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
	}

	public static <T> ServerResponse<T> createSuccess(Integer code, String msg, T data){
		return new ServerResponse<>(code, msg, data);
	}

	public static <T> ServerResponse<T> createSuccessByMessage(String msg){
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg);
	}

	public static <T> ServerResponse<T> createSuccessByData(T data){
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc(),data);
	}

	@JsonIgnore
	public boolean isSuccess(){
		return status == ResponseCode.SUCCESS.getCode();
	}


}