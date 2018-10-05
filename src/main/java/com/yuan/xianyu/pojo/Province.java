/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Province
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:12
 * Description: 省份
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 〈省份〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@Data
@DynamicInsert
public class Province {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 省份名称*/
	private String name;

	/** 排序*/
	@JsonIgnore
	private Integer ordering;

	/** 创建时间*/
	@JsonIgnore
	private Date createTime;

	/** 更新时间*/
	@JsonIgnore
	private Date updateTime;
}