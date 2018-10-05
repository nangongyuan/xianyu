/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Product
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:01
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
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈商品〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@Data
@DynamicInsert
public class Product {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	private Integer userId;

	/** 所属分类*/
	private Integer categoryId;

	/** 名称*/
	private String name;

	/** 所属大学id*/
	private Integer collegeId;


	/** 商品成色*/
	private String quality;

	/** 主图*/
	private String mainImage;

	/** 子图*/
	private String subImages;

	/** 商品详情*/
	private String detail;

	/** 单价*/
	private BigDecimal price;


	/** 状态 1在售 2下架 3已出售*/
	private Integer status;

	/**点击数*/
	private Integer hit;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;
}