/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CategoryVo
 * Author:   Administrator
 * Date:     2018/9/16 0016 13:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.vo;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈展示层分类列表〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Data
public class CategoryListVo implements Serializable {
	private Integer id;

	private String name;

	@JsonProperty("categories")
	private List<CategoryListVo> categoryListVoList;

}