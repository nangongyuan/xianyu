/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Collect
 * Author:   Administrator
 * Date:     2018/9/15 0015 18:51
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
 * 〈收藏〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Collect {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 收藏的商品id*/
	private Integer productId;

	/** 收藏者用户id*/
	private Integer collecter;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;
}