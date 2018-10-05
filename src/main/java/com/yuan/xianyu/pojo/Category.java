/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Category
 * Author:   Administrator
 * Date:     2018/9/15 0015 18:05
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
 * 〈商品分类〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Category {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 父id */
	private Integer parentId;

	/** 分类名称 */
	private String name;

	/** 状态 0不可用 1可用 */
	private Integer status;

	/** 排序 小的在前*/
	private Integer ordering;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;
}