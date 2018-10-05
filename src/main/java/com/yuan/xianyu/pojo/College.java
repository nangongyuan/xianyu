/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: College
 * Author:   Administrator
 * Date:     2018/9/15 0015 18:54
 * Description:
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
 * 〈大学〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class College {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 大学名称*/
	private String name;

	/** 所属省份id*/
	@JsonIgnore
	private Integer provinceId;

	/** 顺序*/
	@JsonIgnore
	private Integer ordering;

	/** 创建时间*/
	@JsonIgnore
	private Date createTime;

	/** 更新时间*/
	@JsonIgnore
	private Date updateTime;

}