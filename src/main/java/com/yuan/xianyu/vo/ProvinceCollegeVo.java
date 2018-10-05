/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProvinceCollegeVo
 * Author:   Administrator
 * Date:     2018/9/16 0016 17:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuan.xianyu.pojo.College;
import lombok.Data;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Data
public class ProvinceCollegeVo {

	private Integer provinceId;

	private String provinceName;

	@JsonProperty("colleges")
	private List<College> collegeList;

	public ProvinceCollegeVo() {
	}

	public ProvinceCollegeVo(Integer provinceId, String provinceName, List<College> collegeList) {
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.collegeList = collegeList;
	}
}