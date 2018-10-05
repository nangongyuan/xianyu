/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProvinceController
 * Author:   Administrator
 * Date:     2018/9/16 0016 16:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.controller;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Province;
import com.yuan.xianyu.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	private IProvinceService provinceService;

	@RequestMapping("/list")
	public ServerResponse<List<Province>> listProvince(){
		return provinceService.listProvince();
	}
}