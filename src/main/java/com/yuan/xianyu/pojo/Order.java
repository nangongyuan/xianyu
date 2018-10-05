/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Order
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 〈订单〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table(name = "product_order")
public class Order {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	private Integer productId;

	/** 买家id*/
	private Integer buyer;

	/** 买家id*/
	private Integer seller;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;
}