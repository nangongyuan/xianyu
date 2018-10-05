/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProvinceServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 14:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Province;
import com.yuan.xianyu.repository.IProvinceRepository;
import com.yuan.xianyu.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {

	@Autowired
	private IProvinceRepository provinceRepository;

	@Override
	public ServerResponse<List<Province>> listProvince() {
		List<Province> provinceList = provinceRepository.findAll(new Sort(Sort.Direction.DESC,"ordering"));
		return ServerResponse.createSuccessByData(provinceList);
	}

	@Override
	public Province getProvinceById(Integer id) {
		return provinceRepository.getOne(id);
	}


}