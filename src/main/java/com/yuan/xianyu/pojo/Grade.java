/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Grade
 * Author:   Administrator
 * Date:     2018/9/15 0015 18:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.omg.CORBA.INTERNAL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 〈评分〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Grade {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 订单id*/
	private Integer orderId;

	/** 评分 1-100*/
	private Integer score;

	/** 评分人*/
	private Integer grader;

	private Integer goaler;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;

	public Grade() {
	}

	public Grade(Integer orderId, Integer score, Integer grader, Integer goaler) {
		this.orderId = orderId;
		this.score = score;
		this.grader = grader;
		this.goaler = goaler;
	}
}