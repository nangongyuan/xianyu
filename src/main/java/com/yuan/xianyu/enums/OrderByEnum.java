/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OrderByEnum
 * Author:   Administrator
 * Date:     2018/9/18 0018 12:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.enums;

import org.springframework.data.domain.Sort;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/18 0018
 * @since 1.0.0
 */
public enum OrderByEnum {

	/** id降序*/
	IDSESC_ORDER(0, new Sort(Sort.Direction.DESC,"id")),

	IDASC_ORDER(1, new Sort(Sort.Direction.ASC,"id")),

	PRICEDESC_ORDER(2, new Sort(Sort.Direction.DESC,"price")),

	PRICEASC_ORDER(3, new Sort(Sort.Direction.ASC,"price")),

	HITDESC_ORDER(4, new Sort(Sort.Direction.DESC,"hit")),

	HITASC_ORDER(5, new Sort(Sort.Direction.ASC,"hit"));

	private int code;
	private Sort sort;

	OrderByEnum(int code, Sort sort) {
		this.code = code;
		this.sort = sort;
	}

	public int getCode() {
		return code;
	}

	public Sort getSort() {
		return sort;
	}

	public static Sort getSort(int code) {
		for (OrderByEnum item: OrderByEnum.values()
			 ) {
			if (code == item.getCode()){
				return item.getSort();
			}
		}
		return null;
	}
}
