/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Chat
 * Author:   Administrator
 * Date:     2018/9/15 0015 18:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 〈聊天记录〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Chat {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 发送人id */
	private Integer sender;

	/** 接收人id */
	private Integer receiver;

	/** 聊天内容 */
	private String content;

	private Integer readContent;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;


	public Chat() {
	}

	public Chat(Integer sender, Integer receiver, String content, Integer readContent) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.readContent = readContent;
	}
}