/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LeaveWord
 * Author:   Administrator
 * Date:     2018/9/15 0015 18:58
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
 * 〈留言〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class LeaveWord {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 商品id*/
	private Integer productId;

	/** 发送者id*/
	private Integer sender;

	/** 发送内容*/
	private String content;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;
}