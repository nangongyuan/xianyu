/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OrderVo
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.vo;

import com.yuan.xianyu.pojo.Product;
import lombok.Data;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
@Data
public class OrderVo {

	private Integer orderId;

	private Product product;

	private String buyer;

	private String seller;

	private Integer grade;

}